package com.ros.inventory.serviceImpl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ros.inventory.Exception.InventoryException;
import com.ros.inventory.Repository.SupplierBasicRepository;
import com.ros.inventory.entities.SupplierBankInfo;
import com.ros.inventory.entities.SupplierBasicInfo;
import com.ros.inventory.service.ISupplierBasicManager;

@Service
public class SupplierBasicManager implements ISupplierBasicManager {
	@Autowired
	SupplierBasicRepository basicRepo;

	
	@Override
	public SupplierBasicInfo showBasic(UUID id) throws InventoryException {
		SupplierBasicInfo infoFromDB = basicRepo.getById(id);
		if (infoFromDB == null) {
			throw new InventoryException(" Information not available");
		}
		return infoFromDB;
	}

	@Override
	public String showimage(UUID id) throws InventoryException {
		String infoFromDB = basicRepo.getImage(id);
		if (infoFromDB == null) {
			throw new InventoryException("Image is not available");
		}
		return infoFromDB;
	}	

}
