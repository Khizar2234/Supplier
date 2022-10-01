package com.ros.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ros.inventory.Exception.InventoryException;
import com.ros.inventory.entities.Product;
import com.ros.inventory.service.ISupplierManager;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {
	@Autowired
	private ISupplierManager suppliermanager;

	@PostMapping("/addProd")
    public ResponseEntity<?> add(@RequestBody Product product){
        ResponseEntity<?> response;

        try{
            response = new ResponseEntity<>(suppliermanager.addProduct(product), HttpStatus.OK);
        }
        catch(InventoryException e){
            response= new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }

        return response;
    }
	
}
