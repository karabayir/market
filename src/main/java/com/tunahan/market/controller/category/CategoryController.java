package com.tunahan.market.controller.category;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tunahan.market.business.abstracts.category.CategoryService;
import com.tunahan.market.core.messages.category.CategoryMessages;
import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.core.utilities.result.Result;
import com.tunahan.market.dtos.requests.category.CreateCategoryRequest;
import com.tunahan.market.dtos.requests.category.UpdateCategoryRequest;
import com.tunahan.market.dtos.responses.category.CreateCategoryResponse;
import com.tunahan.market.dtos.responses.category.GetAllCategoryResponse;
import com.tunahan.market.dtos.responses.category.GetCategoryResponse;
import com.tunahan.market.dtos.responses.category.UpdateCategoryResponse;
import com.tunahan.market.entities.category.Category;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = CategoryMessages.Controller.requestMapping)
@AllArgsConstructor
public class CategoryController {

	private final CategoryService categoryService;
	
	@GetMapping(path = CategoryMessages.Controller.getAll)
	public DataResult<List<GetAllCategoryResponse>> getAll(){
		return categoryService.getAll();
	}
	
	@GetMapping(path = CategoryMessages.Controller.getById)
	public DataResult<GetCategoryResponse> getById(@PathVariable long id) {
		return categoryService.getById(id);
	}
	
	@GetMapping(path = CategoryMessages.Controller.getByName)
	public DataResult<GetCategoryResponse> getByName(@RequestParam String name) {
		return categoryService.getByName(name);
	}
	
	@PostMapping(path = CategoryMessages.Controller.add)
	public DataResult<CreateCategoryResponse> add(@Valid @RequestBody CreateCategoryRequest createRequest) {
		return categoryService.add(createRequest);
	}
	
	@PutMapping(path = CategoryMessages.Controller.update)
	public DataResult<UpdateCategoryResponse> update(@Valid @RequestBody UpdateCategoryRequest request){
		return categoryService.update(request);
	}
	
	@DeleteMapping(path = CategoryMessages.Controller.deleteById)
	public Result delete(@PathVariable long id) {
		return categoryService.delete(id);
	}
	
	@GetMapping(path = CategoryMessages.Controller.pageable)
	public DataResult<Page<Category>> getAllPageable(@RequestParam int number, @RequestParam int size){
		return categoryService.getAllPageable(number, size);
	}
}
