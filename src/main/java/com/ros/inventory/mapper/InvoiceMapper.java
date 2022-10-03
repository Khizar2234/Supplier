package com.ros.inventory.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import com.ros.inventory.controller.dto.InvoiceDto;
import com.ros.inventory.entities.Invoice;
import com.ros.inventory.entities.Product;
import com.ros.inventory.entities.PurchaseOrder;

@Mapper
@Component
public interface InvoiceMapper {
	//basic detail
	@Mapping(source = "purchaseOrder.supplier.supplierBasic.supplierBusinessName", target = "supplierName")
	@Mapping(source = "purchaseOrder.purchaseOrderDate", target = "invoiceDate")
	@Mapping(source = "purchaseOrder.totalAmount", target = "total")
	@Mapping(source = "purchaseOrder.purchasedId", target = "PONumber")
	InvoiceDto convertToInvoiceDto(PurchaseOrder purchaseOrder);
}

