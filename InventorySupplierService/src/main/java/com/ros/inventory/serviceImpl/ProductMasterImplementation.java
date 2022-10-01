package com.ros.inventory.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ros.inventory.Repository.ProductMasterRepository;
import com.ros.inventory.Repository.ProductRepository;
import com.ros.inventory.Repository.SupplierRepository;
import com.ros.inventory.entities.Product;
import com.ros.inventory.entities.ProductMaster;
import com.ros.inventory.service.ProductMasterManager;


@Service
public class ProductMasterImplementation implements ProductMasterManager{

    @Autowired ProductMasterRepository productMasterRepo;
    @Autowired SupplierRepository supplierRepository;
    @Autowired ProductRepository productRepository;

    @Override
    public ProductMaster addProductMaster(UUID supplierID) throws Exception {
        
        ProductMaster newProductMaster;
        if(supplierRepository.existsById(supplierID)){
            newProductMaster = new ProductMaster();
            newProductMaster.setSupplier(supplierRepository.getById(supplierID));
        }
        else{
            throw new Exception("Supplier does not exist in DB. Check id");
        }

        return productMasterRepo.saveAndFlush(newProductMaster);
    }


    @Override
    public Object addProduct(UUID productMasterID, UUID productID) throws Exception {

        if(!productMasterRepo.existsById(productMasterID)){
            throw new Exception("Product master with given id does not exist");
        }
        if(!productRepository.existsById(productID)){
            throw new Exception("Product with given id does not exist");
        }
        ProductMaster temp = productMasterRepo.getProductMasterById(productMasterID);
        List<Product> productList = temp.getProductList();
        productList.add(productRepository.getByID(productID));
        temp.setProductList(productList);

        return productMasterRepo.saveAndFlush(temp);
    }
    
}
