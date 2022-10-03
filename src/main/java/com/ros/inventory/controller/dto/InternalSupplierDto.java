package com.ros.inventory.controller.dto;

import java.util.UUID;

import com.ros.inventory.entities.Address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class InternalSupplierDto {
	
	//BASIC
	private String supplierBusinessName;
	private String supplierTradeName;
    private String restaurantName;
    //ADDRESS
    private String addressLine;
    private String city;
    private String state;
    private String country;
    private long pincode;
    
    //CONTACT
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
	private long mobile;
	private long telephone;
}
