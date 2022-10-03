package com.ros.inventory.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import com.ros.inventory.controller.dto.ProductDto;
import com.ros.inventory.entities.Product;

@Mapper
@Component
public interface ProductMapper {
	@Mapping(source = "p.productId", target = "productId")
	@Mapping(source = "p.productCode", target = "productCode")
	@Mapping(source = "p.productName", target = "productName")
	@Mapping(source = "p.productType", target = "productType")
	@Mapping(source = "p.unitMeasurement", target = "unitMeasurement")
	@Mapping(source = "p.pricePerUnit", target = "pricePerUnit")
	@Mapping(source = "p.productVatTax", target = "productVatTax")
	@Mapping(source = "p.productEffectiveDate", target = "productEffectiveDate")

	ProductDto convertToDto(Product p);

	Product convertToEntity(ProductDto addp);

}
