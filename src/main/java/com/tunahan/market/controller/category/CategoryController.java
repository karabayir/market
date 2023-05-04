package com.tunahan.market.controller.category;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tunahan.market.business.abstracts.category.CategoryService;
import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.dtos.requests.category.CreateCategoryRequest;
import com.tunahan.market.dtos.requests.category.UpdateCategoryRequest;
import com.tunahan.market.dtos.responses.category.CreateCategoryResponse;
import com.tunahan.market.dtos.responses.category.GetAllCategoryResponse;
import com.tunahan.market.dtos.responses.category.GetCategoryResponse;
import com.tunahan.market.dtos.responses.category.UpdateCategoryResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/categories/")
@AllArgsConstructor
public class CategoryController {

	private final CategoryService categoryService;
	
	@GetMapping("getAll")
	public DataResult<List<GetAllCategoryResponse>> getAll(){
		return categoryService.getAll();
	}
	
	@GetMapping("getById/{id}")
	public DataResult<GetCategoryResponse> getById(@PathVariable long id) {
		return categoryService.getById(id);
	}
	
	@GetMapping("getByName")
	public DataResult<GetCategoryResponse> getByName(@RequestParam String name) {
		return categoryService.getByName(name);
	}
	
	@PostMapping("add")
	public DataResult<CreateCategoryResponse> add(@Valid @RequestBody CreateCategoryRequest createRequest) {
		return categoryService.add(createRequest);
	}
	
	@PutMapping("update")
	public DataResult<UpdateCategoryResponse> update(@Valid @RequestBody UpdateCategoryRequest request){
		return categoryService.update(request);
	}
	
	@GetMapping("getAllPagination")
	public DataResult<Slice<GetAllCategoryResponse>> getAllPagination(@RequestParam("page") int page, @RequestParam("pageSize")int pageSize){
		Pageable pageable =PageRequest.of(page, pageSize);
		return categoryService.getAllPagination(pageable);
	}
}
