package com.ros.inventory.mapper;

import java.util.UUID;

import org.mapstruct.Mapping;

import com.ros.inventory.controller.dto.SupplierDto;
import com.ros.inventory.entities.Supplier;

public interface InternalSupplierMapper {

	
	@Mapping(source = "supplier.supplierBasic.supplierBusinessName", target = "supplierName")
	@Mapping(source = "supplier.supplierBasic.supplierTradeName", target = "supplierTradeName")
	@Mapping(source = "supplier.address.addressId", target = "addressId")
	@Mapping(source = "supplier.address.street", target = "street")
	@Mapping(source = "supplier.address.area", target = "area")
	@Mapping(source = "supplier.address.city", target = "city")
	@Mapping(source = "supplier.address.state", target = "state")
	@Mapping(source = "supplier.address.country", target = "country")
	@Mapping(source = "supplier.address.pincode", target = "pincode")
	@Mapping(source = "supplier.supplierContact.email", target = "email")
	@Mapping(source = "supplier.supplierContact.mobile", target = "mobile")
	@Mapping(source = "supplier.supplierContact.telephone", target = "telephone")
	
	SupplierDto convertToSupplierDto(Supplier supplier);
	
	
}
