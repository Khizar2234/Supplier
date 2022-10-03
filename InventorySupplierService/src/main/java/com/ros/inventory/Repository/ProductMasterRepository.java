package com.ros.inventory.Repository;

import java.util.UUID;

import com.ros.inventory.entities.Product;
import com.ros.inventory.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ros.inventory.entities.ProductMaster;

public interface ProductMasterRepository extends JpaRepository<ProductMaster, UUID> {
    ProductMaster getProductMasterById(UUID id);
    ProductMaster getProductMasterBySupplier(Supplier supplier);
    
    @Modifying
	@Query(value = "DELETE from product_master_product_list p where p.product_list_product_id = :product_id", nativeQuery = true)
	void deleteProductFromMaster(@Param("product_id") UUID productId);
    
}
