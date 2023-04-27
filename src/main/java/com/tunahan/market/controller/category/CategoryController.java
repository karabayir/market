package com.tunahan.market.controller.category;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tunahan.market.business.abstracts.category.CategoryService;
import com.tunahan.market.dtos.requests.category.CreateCategoryRequest;
import com.tunahan.market.dtos.requests.intermediate.CreateProductCategoryRequest;
import com.tunahan.market.dtos.responses.category.CreateCategoryResponse;
import com.tunahan.market.dtos.responses.category.GetAllCategoryResponse;
import com.tunahan.market.dtos.responses.category.GetCategoryResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/categories/")
@AllArgsConstructor
public class CategoryController {

	private final CategoryService categoryService;
	
	@GetMapping("getAll")
	public List<GetAllCategoryResponse> getAll(){
		return categoryService.getAll();
	}
	
	@GetMapping("getById/{id}")
	public GetCategoryResponse getById(@PathVariable long id) {
		return categoryService.getById(id);
	}
	
	@GetMapping("getByName")
	public GetCategoryResponse getByName(@RequestParam String name) {
		return categoryService.getByName(name);
	}
	
	@PostMapping("add")
	public CreateCategoryResponse add(@RequestBody CreateCategoryRequest createRequest) {
		return categoryService.add(createRequest);
	}
	
	@PostMapping("addProductToCategory")
	public void addProductToCategory(@RequestBody CreateProductCategoryRequest request) {
		 categoryService.addProductToCategory(request);
	}
}
