package com.ros.inventory.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ros.inventory.Exception.InventoryException;
import com.ros.inventory.service.SupplierBankInfoService;

@RestController
public class SupplierBankInfoController {

	@Autowired
	SupplierBankInfoService sbiservice;
	/*----------------------GETTING BANK DETAILS OF A PARTICULAR SUPPLIER USING ID-----------------------------------*/
	@GetMapping("/bankinfo/{id}")
	public ResponseEntity<?> getBankInfo(@PathVariable(value="id") UUID id){

		ResponseEntity<?> response;
		try {
			response = new ResponseEntity<> (sbiservice.showBankDetails(id),HttpStatus.OK);
		}catch(InventoryException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return response;
	}

}
