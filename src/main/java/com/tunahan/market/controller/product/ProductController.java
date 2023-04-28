package com.tunahan.market.controller.product;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tunahan.market.business.abstracts.product.ProductService;
import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.core.utilities.result.Result;
import com.tunahan.market.dtos.requests.intermediate.CreateProductCategoryRequest;
import com.tunahan.market.dtos.requests.product.CreateProductRequest;
import com.tunahan.market.dtos.responses.product.CreateProductResponse;
import com.tunahan.market.dtos.responses.product.GetAllProductResponse;
import com.tunahan.market.dtos.responses.product.GetProductResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/products/")
@AllArgsConstructor
public class ProductController {

	private final ProductService productService;
	
	@GetMapping("getAll")
	public DataResult<List<GetAllProductResponse>> getAll(){
		return productService.getAll();
	}
	
	@GetMapping("getById/{id}")
	public DataResult<GetProductResponse> getById(@PathVariable long id) {
		return productService.getById(id);
	}
	
	@GetMapping("getByName")
	public DataResult<List<GetAllProductResponse>> getByName(@RequestParam String name){
		return productService.getByName(name);
	}
	
	@PostMapping("add")
	public DataResult<CreateProductResponse> add(@Valid @RequestBody CreateProductRequest createRequest) {
		return productService.add(createRequest);
	}
	
	@PostMapping("addCategoryToProduct")
	public Result addCategoryToProduct(@RequestBody CreateProductCategoryRequest request) {
		return productService.addCategoryToProduct(request);
	}
	
	@GetMapping("getAllCategories/{productId}")
	public DataResult<List<Long>> getAllCategoriesById(@PathVariable long productId){
		return productService.getAllCategoriesById(productId);
	}
}
