package com.ros.inventory.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ros.inventory.entities.ProductMaster;

public interface ProductMasterRepository extends JpaRepository<ProductMaster, UUID> {
    ProductMaster getProductMasterById(UUID id);
}
