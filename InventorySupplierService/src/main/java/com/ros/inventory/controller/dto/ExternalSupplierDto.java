package com.ros.inventory.controller.dto;




import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExternalSupplierDto {
    //basic info
    private String supplierBusinessName;
    private String supplierTradeName;
    private String image;
    //contact info
    private String email;
    private long fax;
    private long mobile;
    private long telephone;
    //address info
    private String street;
    private String area;
    private String city;
    private String state;
    private String country;
    private long pincode;
    //bank info
    private String bankName;
    private String bankBranchName;
    private String accountHolderName;
    private long accountNumber;
    private String bankIFSCCode;
}