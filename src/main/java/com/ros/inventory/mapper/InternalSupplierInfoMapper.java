package com.ros.inventory.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import com.ros.inventory.controller.dto.InternalSupplierDto;
import com.ros.inventory.controller.dto.InternalSupplierInfoDto;
import com.ros.inventory.entities.Supplier;

@Mapper
@Component
public interface InternalSupplierInfoMapper {
	
	@Mapping(source = "supplier.supplierId", target = "supplierId")
	@Mapping(source = "supplier.supplierBasic.supplierBusinessName", target = "supplierBusinessName")
	@Mapping(source = "supplier.supplierBasic.supplierTradeName", target = "supplierTradeName")
	@Mapping(source = "supplier.restaurantName", target = "restaurantName")
	@Mapping(source = "supplier.supplierAddress.addressLine", target = "addressLine")
	@Mapping(source = "supplier.supplierAddress.city", target = "city")
	@Mapping(source = "supplier.supplierAddress.state", target = "state")
	@Mapping(source = "supplier.supplierAddress.country", target = "country")
	@Mapping(source = "supplier.supplierAddress.pincode", target = "pincode")
	@Mapping(source = "supplier.supplierContact.firstName", target = "firstName")
	@Mapping(source = "supplier.supplierContact.middleName", target = "middleName")
	@Mapping(source = "supplier.supplierContact.lastName", target = "lastName")
	@Mapping(source = "supplier.supplierContact.email", target = "email")
	@Mapping(source = "supplier.supplierContact.mobile", target = "mobile")
	@Mapping(source = "supplier.supplierContact.telephone", target = "telephone")
	InternalSupplierInfoDto convertToInternalSupplierInfoDto(Supplier supplier);
	
	@Mapping(source = "supplierId", target = "supplierId")
	@Mapping(source = "supplierBusinessName", target = "supplierBasic.supplierBusinessName")
	@Mapping(source = "supplierTradeName", target = "supplierBasic.supplierTradeName")
	@Mapping(source = "restaurantName", target = "restaurantName")
	@Mapping(source = "addressLine", target = "supplierAddress.addressLine")
	@Mapping(source = "city", target = "supplierAddress.city")
	@Mapping(source = "state", target = "supplierAddress.state")
	@Mapping(source = "country", target = "supplierAddress.country")
	@Mapping(source = "pincode", target = "supplierAddress.pincode")
	@Mapping(source = "firstName", target = "supplierContact.firstName")
	@Mapping(source = "middleName", target = "supplierContact.middleName")
	@Mapping(source = "lastName", target = "supplierContact.lastName")
	@Mapping(source = "email", target = "supplierContact.email")
	@Mapping(source = "mobile", target = "supplierContact.mobile")
	@Mapping(source = "telephone", target = "supplierContact.telephone")
	Supplier convertToSupplierEntity(InternalSupplierInfoDto supplier);

}
