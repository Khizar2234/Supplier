package com.ros.inventory.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ros.inventory.serviceImpl.ProductMasterImplementation;



@RestController
public class ProductMasterController {
    
    @Autowired ProductMasterImplementation productMasterSer;

    /*-------------------------------------- Add Product Master to a supplier ----------------------------------- */
    @PostMapping("/addPM/{supplierID}")
    public ResponseEntity<?> add(@PathVariable(value = "supplierID") UUID supplierID) throws Exception{
        ResponseEntity<?> response;
        try{
            response = new ResponseEntity<>(productMasterSer.addProductMaster(supplierID), HttpStatus.OK);
        }
        catch(Exception e){
            response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
        return response;
    }  


    /*---------------------------- Add product to Product Master --------------------------------------------- */
    @PostMapping("/addPMO/{productMasterID}/{productID}")
    public ResponseEntity<?> addP(
        @PathVariable(value = "productMasterID") UUID productMasterID,
        @PathVariable(value = "productID") UUID productID) throws Exception {


        ResponseEntity<?> responseEntity;
        try{
            responseEntity = new ResponseEntity<>(productMasterSer.addProduct(productMasterID, productID), HttpStatus.OK);
        }
        catch(Exception e){
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }

        return responseEntity;
    }


    /*-------------View Product Master-------------------------- */
    @GetMapping("/getPMO/{productMasterID}")
    public ResponseEntity<?> get(
        @PathVariable(value = "productMasterID") UUID productMasterID) throws Exception
    {
        ResponseEntity<?> response;

        try{
            response = new ResponseEntity<>(productMasterSer.viewProductMaster(productMasterID), HttpStatus.OK);
        }
        catch(Exception e){
            response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }

        return response;
    }
}
