package com.tunahan.market.business.abstracts.category;

import java.util.List;

import com.tunahan.market.dtos.requests.category.CreateCategoryRequest;
import com.tunahan.market.dtos.requests.intermediate.CreateProductCategoryRequest;
import com.tunahan.market.dtos.responses.category.CreateCategoryResponse;
import com.tunahan.market.dtos.responses.category.GetAllCategoryResponse;
import com.tunahan.market.dtos.responses.category.GetCategoryResponse;

public interface CategoryService {

	List<GetAllCategoryResponse> getAll();
	GetCategoryResponse getById(long id);
	GetCategoryResponse getByName(String name);
	CreateCategoryResponse add(CreateCategoryRequest createRequest); 
	void addProductToCategory(CreateProductCategoryRequest request);
}
