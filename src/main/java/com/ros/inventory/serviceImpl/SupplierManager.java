package com.ros.inventory.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ros.inventory.controller.ProductController;
import com.ros.inventory.entities.SupplierStatus;
import com.ros.inventory.entities.SupplierType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ros.inventory.Exception.InventoryException;
import com.ros.inventory.Repository.ProductMasterRepository;
import com.ros.inventory.Repository.ProductRepository;
import com.ros.inventory.Repository.SupplierRepository;
import com.ros.inventory.controller.dto.AddProductDto;
import com.ros.inventory.controller.dto.ExternalSupplierDto;
import com.ros.inventory.controller.dto.ExternalSupplierInfoDto;
import com.ros.inventory.controller.dto.InternalSupplierDto;
import com.ros.inventory.controller.dto.InternalSupplierInfoDto;
import com.ros.inventory.controller.dto.ProductDto;
import com.ros.inventory.controller.dto.SupplierDescriptionDto;
import com.ros.inventory.controller.dto.SupplierDto;
import com.ros.inventory.entities.Product;
import com.ros.inventory.entities.Supplier;
import com.ros.inventory.mapper.AddProductMapper;
import com.ros.inventory.mapper.ExternalSupplierInfoMapper;
import com.ros.inventory.mapper.ExternalSupplierMapper;
import com.ros.inventory.mapper.InternalSupplierInfoMapper;
import com.ros.inventory.mapper.InternalSupplierMapper;
import com.ros.inventory.mapper.ProductMapper;
import com.ros.inventory.mapper.SupplierDescriptionMapper;
import com.ros.inventory.mapper.SupplierMapper;
import com.ros.inventory.service.ISupplierManager;

@Service
@Transactional
public class SupplierManager implements ISupplierManager {
	@Autowired
	SupplierRepository supplyRepo;

	@Autowired
	private SupplierMapper supplierMapper;

	@Autowired
	private SupplierDescriptionMapper exMapper;

	@Autowired
	private AddProductMapper addMapper;

	@Autowired
	private ExternalSupplierMapper exSupMapper;

	@Autowired
	private InternalSupplierMapper inSupMapper;

	@Autowired
	private InternalSupplierInfoMapper inSupInfoMapper;

	@Autowired
	private ExternalSupplierInfoMapper exSupInfoMapper;

	@Autowired
	private ProductMapper pMapper;

	@Autowired
	ProductRepository productRepository;

	@Override
	public Supplier saveSupplier(ExternalSupplierDto supply) throws InventoryException {
		// TODO Auto-generated method stub

		Supplier supplierEntity = exSupMapper.convertToSupplierEntity(supply);
		supplierEntity.setSupplierType(SupplierType.External);
		supplierEntity.setSupplierStatus(SupplierStatus.Active);

		/*
		 * Supplier supplierFromDB = supplyRepo.getById(supplierEntity.getSupplierId());
		 * 
		 * if (supplierFromDB != null) { throw new
		 * InventoryException("Supplier Already Exist"); }
		 */

		return supplyRepo.saveAndFlush(supplierEntity);
	}

	@Override
	public Supplier saveSupplier(InternalSupplierDto supply) throws InventoryException {
		// TODO Auto-generated method stub

		Supplier supplierEntity = inSupMapper.convertToSupplierEntity(supply);
		supplierEntity.setSupplierType(SupplierType.Internal);
		supplierEntity.setSupplierStatus(SupplierStatus.Active);

		/*
		 * Supplier supplierFromDB = supplyRepo.getById(supplierEntity.getSupplierId());
		 * 
		 * if (supplierFromDB != null) { throw new
		 * InventoryException("Supplier Already Exist"); }
		 */

		return supplyRepo.saveAndFlush(supplierEntity);
	}

	@Override
	@Modifying
	public Supplier updateSupplier(InternalSupplierInfoDto supplierInfo) throws InventoryException {
		// TODO Auto-generated method stub

		Supplier supply = inSupInfoMapper.convertToSupplierEntity(supplierInfo);

		supply.setProducts(null);

		Supplier supplier = supplyRepo.getById(supply.getSupplierId());

		supply.setProducts(supplier.getProducts());
		supply.setSupplierStatus(supplier.getSupplierStatus());
		supply.setSupplierType(supplier.getSupplierType());

		return supplyRepo.saveAndFlush(supply);
	}

	@Override
	@Modifying
	public Supplier updateSupplier(ExternalSupplierInfoDto supplierInfo) throws InventoryException {
		// TODO Auto-generated method stub

		Supplier supply = exSupInfoMapper.convertToSupplierEntity(supplierInfo);

		supply.setProducts(null);

		Supplier supplier = supplyRepo.getById(supply.getSupplierId());

		supply.setProducts(supplier.getProducts());
		supply.setSupplierStatus(supplier.getSupplierStatus());
		supply.setSupplierType(supplier.getSupplierType());

		return supplyRepo.saveAndFlush(supply);
	}

	@Override
	public List<SupplierDto> show() throws InventoryException {
		// TODO Auto-generated method stub
		List<Supplier> supplierFromDB = supplyRepo.getAll();

		// Filters out all the inactive suppliers
		
		//List<Supplier> activeSuppliers = supplierFromDB.stream().filter(p -> p.getSupplierStatus() == SupplierStatus.Active).toList();

		List<Supplier> activeSuppliers = new ArrayList<>();
		for(Supplier supplier: supplierFromDB) {
			if(supplier.getSupplierStatus() == SupplierStatus.Active)
				activeSuppliers.add(supplier);
		}
		
		if (activeSuppliers == null || activeSuppliers.size() == 0) {
			throw new InventoryException(" No Supplier Is Present");
		}

		List<SupplierDto> suppdto = new ArrayList<SupplierDto>();

		for (Supplier s : activeSuppliers) {
			SupplierDto d = supplierMapper.convertToSupplierDto(s);
			suppdto.add(d);
		}

		return suppdto;
	}

	@Override
	public Supplier delete(UUID id) throws InventoryException {
		// TODO Auto-generated method stub
		Supplier supplierFromDB = supplyRepo.getById(id);

		if ((supplierFromDB == null) || (supplierFromDB.getSupplierStatus() == SupplierStatus.NotActive)) {
			throw new InventoryException("No Supplier is present");
		} else {
			supplyRepo.deleteSupplier(id);
			supplierFromDB.setSupplierStatus(SupplierStatus.NotActive);
		}
		return supplierFromDB;
	}

	@Override
	public List<SupplierDto> byName(String sName) throws InventoryException {
		// TODO Auto-generated method stub
		List<Supplier> supplierFromDB = supplyRepo.getByName(sName);
		List<SupplierDto> supplierDtos = new ArrayList<SupplierDto>();
		// Supplier supplierFromDB = supplyRepo.getByName(sName);
		
		//List<Supplier> activeSuppliers = supplierFromDB.stream().filter(p -> p.getSupplierStatus() == SupplierStatus.Active).toList();
		
		List<Supplier> activeSuppliers = new ArrayList<>();
		for(Supplier supplier: supplierFromDB) {
			if(supplier.getSupplierStatus() == SupplierStatus.Active)
				activeSuppliers.add(supplier);
		}
		
		if (activeSuppliers.isEmpty()) {
			throw new InventoryException(" No Active Supplier Is Present by this name");
		} else {
			for (Supplier supplier : activeSuppliers) {
				SupplierDto dto = supplierMapper.convertToSupplierDto(supplier);
				supplierDtos.add(dto);
			}
		}

		return supplierDtos;
	}

	@Override
	public InternalSupplierInfoDto externalSupplierDesc(UUID id) throws InventoryException {
		// TODO Auto-generated method stub

		Supplier supplierFromDB = supplyRepo.getById(id);
		if (supplierFromDB == null) {
			throw new InventoryException("Supplier Details is not present");
		}

		InternalSupplierInfoDto Dto = inSupInfoMapper.convertToInternalSupplierInfoDto(supplierFromDB);
		return Dto;

	}

	@Override
	public ExternalSupplierInfoDto internalSupplierDesc(UUID id) throws InventoryException {
		// TODO Auto-generated method stub

		Supplier supplierFromDB = supplyRepo.getById(id);
		if (supplierFromDB == null) {
			throw new InventoryException("Supplier Details is not present");
		}

		ExternalSupplierInfoDto Dto = exSupInfoMapper.convertToExternalSupplierInfoDto(supplierFromDB);
		return Dto;

	}

	@Override
	// It's working for now, if it gives error, comments this out and use above
	public Object description(UUID id) throws InventoryException {
		// TODO Auto-generated method stub

		Supplier supplierFromDB = supplyRepo.getById(id);
		
		if(supplierFromDB.getSupplierStatus() == SupplierStatus.NotActive)
			throw new InventoryException("Supplier Details is not present");

		if (supplierFromDB.getSupplierType() == SupplierType.External) {
			return exSupInfoMapper.convertToExternalSupplierInfoDto(supplierFromDB);
		}
		return inSupInfoMapper.convertToInternalSupplierInfoDto(supplierFromDB);
	}

	@Override
	public Product addProduct(Product addProduct) throws InventoryException {

		Product product = productRepository.getByID(addProduct.getProductId());
		if(product != null){
			throw new InventoryException("Product already in database. Cannot add, can only be updated.");
		}
		return productRepository.saveAndFlush(addProduct);
	}

	@Override public Product editProduct(Product product) throws InventoryException {

		Product product1 = productRepository.getByID(product.getProductId());
		if(product1 == null){
			throw new InventoryException("Product does not exist in database");
		}

		Product productFromDB = productRepository.getByID(product.getProductId());
		productFromDB = product;

		return productRepository.saveAndFlush(productFromDB);
	}

	@Override public List<Product> viewAllProducts() throws InventoryException {
		List<Product> productList = productRepository.getAll();
		if(productList == null){
			throw new InventoryException("No products in db.");
		}
		else{
			// Convert to DTO if required
			// If multiple product DTO types are there then change method signature to type List<Object>
			return productList;
		}
	}
}
