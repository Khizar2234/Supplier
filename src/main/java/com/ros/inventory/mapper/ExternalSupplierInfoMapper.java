package com.ros.inventory.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import com.ros.inventory.controller.dto.ExternalSupplierInfoDto;
import com.ros.inventory.entities.Supplier;

@Mapper
@Component
public interface ExternalSupplierInfoMapper {
	@Mapping(source = "supplier.supplierId", target = "supplierId")
	@Mapping(source = "supplier.supplierBasic.supplierBusinessName", target = "supplierBusinessName")
	@Mapping(source = "supplier.supplierBasic.supplierTradeName", target = "supplierTradeName")
	@Mapping(source = "supplier.supplierBasic.image", target = "image")
//    @Mapping(source = "supplier.supplierType", target = "supplierType")

	@Mapping(source = "supplier.supplierContact.email", target = "email")
	@Mapping(source = "supplier.supplierContact.mobile", target = "mobile")
	@Mapping(source = "supplier.supplierContact.fax", target = "fax")
	@Mapping(source = "supplier.supplierContact.telephone", target = "telephone")

	@Mapping(source = "supplier.supplierAddress.addressLine", target = "addressLine")
	@Mapping(source = "supplier.supplierAddress.city", target = "city")
	@Mapping(source = "supplier.supplierAddress.state", target = "state")
	@Mapping(source = "supplier.supplierAddress.country", target = "country")
	@Mapping(source = "supplier.supplierAddress.pincode", target = "pincode")

	@Mapping(source = "supplier.supplierBank.bankName", target = "bankName")
	@Mapping(source = "supplier.supplierBank.bankBranchName", target = "bankBranchName")
	@Mapping(source = "supplier.supplierBank.accountHolderName", target = "accountHolderName")
	@Mapping(source = "supplier.supplierBank.accountNumber", target = "accountNumber")
	@Mapping(source = "supplier.supplierBank.bankIFSCCode", target = "bankIFSCCode")
	ExternalSupplierInfoDto convertToExternalSupplierInfoDto(Supplier supplier);

	
	@Mapping(source = "supplierId", target = "supplierId")
	@Mapping(source = "supplierBusinessName", target = "supplierBasic.supplierBusinessName")
	@Mapping(source = "supplierTradeName", target = "supplierBasic.supplierTradeName")
	@Mapping(source = "image", target = "supplierBasic.image")
//    @Mapping(source = "supplier.supplierType", target = "supplierType")

	@Mapping(source = "email", target = "supplierContact.email")
	@Mapping(source = "mobile", target = "supplierContact.mobile")
	@Mapping(source = "fax", target = "supplierContact.fax")
	@Mapping(source = "telephone", target = "supplierContact.telephone")

	@Mapping(source = "addressLine", target = "supplierAddress.addressLine")
	@Mapping(source = "city", target = "supplierAddress.city")
	@Mapping(source = "state", target = "supplierAddress.state")
	@Mapping(source = "country", target = "supplierAddress.country")
	@Mapping(source = "pincode", target = "supplierAddress.pincode")

	@Mapping(source = "bankName", target = "supplierBank.bankName")
	@Mapping(source = "bankBranchName", target = "supplierBank.bankBranchName")
	@Mapping(source = "accountHolderName", target = "supplierBank.accountHolderName")
	@Mapping(source = "accountNumber", target = "supplierBank.accountNumber")
	@Mapping(source = "bankIFSCCode", target = "supplierBank.bankIFSCCode")
	Supplier convertToSupplierEntity(ExternalSupplierInfoDto supplier);

}