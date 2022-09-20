package com.ros.inventory.service;

import java.util.UUID;

import com.ros.inventory.Exception.InventoryException;
import com.ros.inventory.entities.SupplierBankInfo;

public interface SupplierBankInfoService {
	
	SupplierBankInfo showBankDetails(UUID id) throws InventoryException;

}
