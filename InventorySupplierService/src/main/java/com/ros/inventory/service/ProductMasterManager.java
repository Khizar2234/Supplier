package com.ros.inventory.service;

import java.util.UUID;

import com.ros.inventory.entities.ProductMaster;

public interface ProductMasterManager {
    public ProductMaster addProductMaster(UUID supplierID) throws Exception;
    public Object addProduct(UUID productMasterID, UUID productID) throws Exception;
}
