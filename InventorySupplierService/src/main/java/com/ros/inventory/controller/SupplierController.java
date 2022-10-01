package com.ros.inventory.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ros.inventory.Exception.InventoryException;
import com.ros.inventory.controller.dto.AddProductDto;
import com.ros.inventory.controller.dto.ExternalSupplierDto;
import com.ros.inventory.controller.dto.ExternalSupplierInfoDto;
import com.ros.inventory.controller.dto.InternalSupplierDto;
import com.ros.inventory.controller.dto.InternalSupplierInfoDto;
import com.ros.inventory.entities.Product;
import com.ros.inventory.entities.Supplier;
import com.ros.inventory.service.ISupplierManager;

@RestController
@RequestMapping("/supplier")
@CrossOrigin("*")
public class SupplierController {
	@Autowired
	private ISupplierManager suppliermanager;

	/*-------------- FOR ADDING SUPPLIER ------------------------------------*/
//	@PostMapping("/add")
//	@ResponseBody
//	public ResponseEntity<?> add(@RequestBody Supplier supply) {
//		ResponseEntity<?> response;
//		try {
//			response = new ResponseEntity<>(suppliermanager.saveSupplier(supply), HttpStatus.OK);
//		} catch (InventoryException e) {
//			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
//			e.printStackTrace();
//		}
//		return response;
//	}
	
	/*-------------- FOR ADDING EXTERNAL SUPPLIER ------------------------------------*/
	@PostMapping("/addExt")
	@ResponseBody
	public ResponseEntity<?> add(@RequestBody ExternalSupplierDto supply) {
		ResponseEntity<?> response;
		try {
			response = new ResponseEntity<>(suppliermanager.saveSupplier(supply), HttpStatus.OK);
		} catch (InventoryException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
			e.printStackTrace();
		}
		return response;
	}
	
	/*-------------- FOR ADDING INTERNAL SUPPLIER ------------------------------------*/
	@PostMapping("/addInt")
	@ResponseBody
	public ResponseEntity<?> add(@RequestBody InternalSupplierDto supply) {
		ResponseEntity<?> response;
		try {
			response = new ResponseEntity<>(suppliermanager.saveSupplier(supply), HttpStatus.OK);
		} catch (InventoryException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
			e.printStackTrace();
		}
		return response;
	}

//	/*------------------- FOR UPDATING SUPPLIER ----------------------------------*/
//	@PutMapping("/update")
//	@ResponseBody
//	public ResponseEntity<?> update(@RequestBody Supplier supply) {
//		ResponseEntity<?> response;
//		try {
//			response = new ResponseEntity<>(suppliermanager.updateSupplier(supply), HttpStatus.OK);
//		} catch (InventoryException e) {
//			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
//			e.printStackTrace();
//		}
//		return response;
//	}
	
	/*------------------- FOR UPDATING INTERNAL SUPPLIER ----------------------------------*/
	@PutMapping("/updateInt")
	@ResponseBody
	public ResponseEntity<?> update(@RequestBody InternalSupplierInfoDto supply) {
		ResponseEntity<?> response;
		try {
			response = new ResponseEntity<>(suppliermanager.updateSupplier(supply), HttpStatus.OK);
		} catch (InventoryException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
			e.printStackTrace();
		}
		return response;
	}
	
	/*------------------- FOR UPDATING EXTERNAL SUPPLIER ----------------------------------*/
	@PutMapping("/updateExt")
	@ResponseBody
	public ResponseEntity<?> update(@RequestBody ExternalSupplierInfoDto supply) {
		ResponseEntity<?> response;
		try {
			response = new ResponseEntity<>(suppliermanager.updateSupplier(supply), HttpStatus.OK);
		} catch (InventoryException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
			e.printStackTrace();
		}
		return response;
	}

	/*--------------------FOR GETTING LIST OF ALL SUPPLIER DTO --------------------------------*/
	@GetMapping("/show")
	@ResponseBody
	public ResponseEntity<?> show() {
		ResponseEntity<?> response;
		try {
			response = new ResponseEntity<>(suppliermanager.show(), HttpStatus.OK);
		} catch (InventoryException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
			e.printStackTrace();
		}
		return response;
	}

	/*-------------------------- FOR GETTING PARTICULAR SUPPLIER BY NAME DTO-------------------------*/
	@GetMapping("/name/{sName}")
	@ResponseBody
	public ResponseEntity<?> bySupplierName(@PathVariable(value = "sName") String sName) {
		ResponseEntity<?> response;
		try {
			response = new ResponseEntity<>(suppliermanager.byName(sName.toLowerCase()), HttpStatus.OK);
		} catch (InventoryException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
			e.printStackTrace();

		}

		return response;
	}

	/*--------------------- FOR DELETING THE SUPPLIER ------------------------------*/
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public ResponseEntity<?> delete(@PathVariable(value = "id") UUID id) {
		ResponseEntity<?> response;
		try {
			response = new ResponseEntity<>(suppliermanager.delete(id), HttpStatus.OK);
		} catch (InventoryException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
			e.printStackTrace();
		}
		return response;
	}

	/*------------------------------ FOR VEIWING THE PARTICULAR EXTERNAL SUPPLIER DESCRIPTION------------------------------ */
	@GetMapping("/descExt/{id}")
	@ResponseBody
	public ResponseEntity<?> getExternalDescription(@PathVariable(value = "id") UUID id) {
		ResponseEntity<?> response;
		try {
			response = new ResponseEntity<>(suppliermanager.externalSupplierDesc(id), HttpStatus.OK);
		} catch (InventoryException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
			e.printStackTrace();
		}
		return response;
	}
	
	/*------------------------------ FOR VEIWING THE PARTICULAR INTERNAL SUPPLIER DESCRIPTION------------------------------ */
	@GetMapping("/descInt/{id}")
	@ResponseBody
	public ResponseEntity<?> getInternalDescription(@PathVariable(value = "id") UUID id) {
		ResponseEntity<?> response;
		try {
			response = new ResponseEntity<>(suppliermanager.internalSupplierDesc(id), HttpStatus.OK);
		} catch (InventoryException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
			e.printStackTrace();
		}
		return response;
	}
	
	//If any error comes in this, remove this and use above mappings
	/*------------------------------ FOR VEIWING THE PARTICULAR SUPPLIER DESCRIPTION------------------------------ */
	@GetMapping("/desc/{id}")
	@ResponseBody
	public ResponseEntity<?> getDescription(@PathVariable(value = "id") UUID id) {
		ResponseEntity<?> response;
		try {
			response = new ResponseEntity<>(suppliermanager.description(id), HttpStatus.OK);
		} catch (InventoryException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
			e.printStackTrace();
		}
		return response;
	}

	// @PostMapping("/addProd")
    // public ResponseEntity<?> add(@RequestBody Product product){
    //     ResponseEntity<?> response;

    //     try{
    //         response = new ResponseEntity<>(suppliermanager.addProduct(product), HttpStatus.OK);
    //     }
    //     catch(InventoryException e){
    //         response= new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
    //     }

    //     return response;
    // }
	
}
