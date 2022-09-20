package com.ros.inventory.service;

import java.util.UUID;

import com.ros.inventory.Exception.InventoryException;
import com.ros.inventory.entities.SupplierBankInfo;
import com.ros.inventory.entities.SupplierBasicInfo;

public interface ISupplierBasicManager
{

	SupplierBasicInfo showBasic(UUID id) throws InventoryException;

	String showimage(UUID id) throws InventoryException;
	
}
