package com.ros.inventory.serviceImpl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ros.inventory.Exception.InventoryException;
import com.ros.inventory.Repository.SupplierBankInfoRepository;
import com.ros.inventory.entities.SupplierBankInfo;
import com.ros.inventory.service.SupplierBankInfoService;

@Service
public class SupplierBankInfoImpl implements SupplierBankInfoService{
	
	@Autowired
	SupplierBankInfoRepository sbirepo;

	@Override
	public SupplierBankInfo showBankDetails(UUID id) throws InventoryException {
		
		SupplierBankInfo sbi = sbirepo.getBankDetailsById(id);
		if (sbi == null) {
			throw new InventoryException(" BankDetails not available");
		}
		return sbi;
	}

}
