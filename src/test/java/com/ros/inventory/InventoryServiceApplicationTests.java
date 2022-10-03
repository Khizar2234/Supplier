package com.ros.inventory;

import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.assertj.core.internal.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ros.inventory.Repository.SupplierRepository;
import com.ros.inventory.controller.dto.ExternalSupplierDto;
import com.ros.inventory.controller.dto.SupplierDto;
import com.ros.inventory.entities.Product;
import com.ros.inventory.entities.Supplier;
import com.ros.inventory.entities.SupplierBasicInfo;
import com.ros.inventory.mapper.ExternalSupplierMapper;
import com.ros.inventory.service.ISupplierBasicManager;
import com.ros.inventory.service.ISupplierManager;
import com.ros.inventory.service.ProductMasterManager;
import com.ros.inventory.service.SupplierBankInfoService;
import com.ros.inventory.serviceImpl.ProductMasterImplementation;
import com.ros.inventory.serviceImpl.SupplierManager;

//import javassist.NotFoundException;



@WebMvcTest
class InventoryServiceApplicationTests {

	@Autowired MockMvc mvc;

	@MockBean ISupplierBasicManager iSupplierBasicManager;
	@MockBean SupplierManager iSupplierManager;
	@MockBean ProductMasterImplementation productMasterImplementation;
	@MockBean SupplierBankInfoService supplierBankInfoService;

	@MockBean ExternalSupplierMapper externalSupplierMapper;

	public static ObjectMapper mapper = new ObjectMapper();
	private static UUID uuid = UUID.randomUUID();

	@Test
	void saveProducts_SUCCESS() throws Exception {
		Product product = new Product();
		product.setProductId(uuid);
		product.setProductName("prodnametest");

		String json = mapper.writeValueAsString(product);
		when(iSupplierManager.addProduct(ArgumentMatchers.any())).thenReturn(product);

		mvc.perform(post("/product/addProd").content(json).contentType(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON)
		.characterEncoding("utf-8")).andExpect(status().isOk())
		.andExpect(jsonPath("$.productName", Matchers.equalTo("prodnametest")));
	}


	@Test
	void editProducts_SUCCESS() throws Exception {
		Product product = new Product();
		product.setProductId(uuid);
		product.setProductName("prodnametest");

		String json = mapper.writeValueAsString(product);
		when(iSupplierManager.editProduct(ArgumentMatchers.any())).thenReturn(product);

		mvc.perform(put("/product/editProduct").content(json).contentType(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON)
		.characterEncoding("utf-8")).andExpect(status().isOk())
		.andExpect(jsonPath("$.productName", Matchers.equalTo("prodnametest")));
	}

	
	@Test
	void deleteProducts_SUCCESS() throws Exception {
		//
	}


	// @Test
	// void saveExtSupplier_SUCCESS() throws Exception {
	// 	SupplierBasicInfo supplierBasicInfo = new SupplierBasicInfo();
	// 	supplierBasicInfo.setSupplierBusinessName("supBussTest");

	// 	Supplier supplier = new Supplier();
	// 	supplier.setSupplierBasic(supplierBasicInfo);

	// 	ExternalSupplierDto externalSupplierDto = externalSupplierMapper.convertToExternalSupplierDto(supplier);
	// 	String json = mapper.writeValueAsString(externalSupplierDto);
	// 	when(iSupplierManager.saveSupplier(externalSupplierDto)).thenReturn(supplier);

	// 	mvc.perform(put("/supplier/addExt").content(json).contentType(MediaType.APPLICATION_JSON)
	// 	.accept(MediaType.APPLICATION_JSON)
	// 	.characterEncoding("utf-8")).andExpect(status().isOk())
	// 	.andExpect(jsonPath("$.supplierBasic.supplierBusinessName", Matchers.equalTo("supBussTest")));
	// }
}