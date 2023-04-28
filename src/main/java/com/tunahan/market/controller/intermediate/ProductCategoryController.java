package com.tunahan.market.controller.intermediate;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tunahan.market.business.abstracts.intermediate.ProductCategoryService;
import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.dtos.responses.intermediate.GetAllProductCategoryResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/productControllers/")
@AllArgsConstructor
public class ProductCategoryController {

	private final ProductCategoryService service;
	
	@GetMapping("getAll")
	public DataResult<List<GetAllProductCategoryResponse>> getAll(){
		return service.getAll();
	}
	
}
