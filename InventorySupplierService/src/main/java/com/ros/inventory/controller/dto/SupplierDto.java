package com.ros.inventory.controller.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDto 
{
	private UUID supplierId;
	private String supplierName;
	private String supplierType;
	private String email;
	private long mobile;
	    
}
