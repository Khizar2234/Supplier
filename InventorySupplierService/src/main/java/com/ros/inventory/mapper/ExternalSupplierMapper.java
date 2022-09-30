package com.ros.inventory.mapper;



import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;



import com.ros.inventory.controller.dto.ExternalSupplierDto;
import com.ros.inventory.entities.Supplier;



@Mapper
@Component
public interface ExternalSupplierMapper {
    @Mapping(source = "supplier.supplierBasic.supplierBusinessName", target = "supplierBusinessName")
    @Mapping(source = "supplier.supplierBasic.supplierTradeName", target = "supplierTradeName")
    @Mapping(source = "supplier.supplierBasic.image", target = "image")
//    @Mapping(source = "supplier.supplierType", target = "supplierType")
    
    @Mapping(source = "supplier.supplierContact.email", target = "email")
    @Mapping(source = "supplier.supplierContact.mobile", target = "mobile")
    @Mapping(source = "supplier.supplierContact.fax", target = "fax")
    @Mapping(source = "supplier.supplierContact.telephone", target = "telephone")
    
    @Mapping(source = "supplier.supplierAddress.street", target = "street")
    @Mapping(source = "supplier.supplierAddress.area", target = "area")
    @Mapping(source = "supplier.supplierAddress.city", target = "city")
    @Mapping(source = "supplier.supplierAddress.state", target = "state")
    @Mapping(source = "supplier.supplierAddress.country", target = "country")
    @Mapping(source = "supplier.supplierAddress.pincode", target = "pincode")
    
    @Mapping(source = "supplier.supplierBank.bankName", target = "bankName")
    @Mapping(source = "supplier.supplierBank.bankBranchName", target = "bankBranchName")
    @Mapping(source = "supplier.supplierBank.accountHolderName", target = "accountHolderName")
    @Mapping(source = "supplier.supplierBank.accountNumber", target = "accountNumber")
    @Mapping(source = "supplier.supplierBank.bankIFSCCode", target = "bankIFSCCode")
    
    ExternalSupplierDto convertToExternalSupplierDto(Supplier supplier);
    




    
}