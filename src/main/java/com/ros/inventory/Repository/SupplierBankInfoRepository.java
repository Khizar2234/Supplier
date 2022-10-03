package com.ros.inventory.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ros.inventory.entities.SupplierBankInfo;

@Repository
public interface SupplierBankInfoRepository extends JpaRepository<SupplierBankInfo, UUID>{
	
	@Query(value="SELECT * FROM supplier_bank_info sbi LEFT JOIN supplier sp on  sbi.bank_id =sp.supplierbank_id "
			+ " WHERE sp.supplier_id =:supplier_id",nativeQuery=true)
	SupplierBankInfo getBankDetailsById(@Param("supplier_id") UUID Id);
	
}
