package com.ros.inventory.service;

import java.util.List;
import java.util.UUID;

import com.ros.inventory.Exception.InventoryException;
import com.ros.inventory.controller.dto.ExternalSupplierDto;
import com.ros.inventory.controller.dto.ExternalSupplierInfoDto;
import com.ros.inventory.controller.dto.InternalSupplierDto;
import com.ros.inventory.controller.dto.InternalSupplierInfoDto;
import com.ros.inventory.controller.dto.SupplierDescriptionDto;
import com.ros.inventory.controller.dto.SupplierDto;
import com.ros.inventory.entities.Supplier;

public interface ISupplierManager {

	Supplier saveSupplier(ExternalSupplierDto supply) throws InventoryException;

	Supplier saveSupplier(InternalSupplierDto supply) throws InventoryException;

	Supplier updateSupplier(InternalSupplierInfoDto supply) throws InventoryException;

	Supplier updateSupplier(ExternalSupplierInfoDto supply) throws InventoryException;

	List<SupplierDto> show() throws InventoryException;

	Supplier delete(UUID id) throws InventoryException;

	List<SupplierDto> byName(String sName) throws InventoryException;

	Object description(UUID id) throws InventoryException;

	InternalSupplierInfoDto externalSupplierDesc(UUID id) throws InventoryException;

	ExternalSupplierInfoDto internalSupplierDesc(UUID id) throws InventoryException;

	Supplier addProduct(Supplier add) throws InventoryException;

}
