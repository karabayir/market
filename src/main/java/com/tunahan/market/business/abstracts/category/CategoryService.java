package com.tunahan.market.business.abstracts.category;

import java.util.List;

import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.core.utilities.result.Result;
import com.tunahan.market.dtos.requests.category.CreateCategoryRequest;
import com.tunahan.market.dtos.requests.intermediate.CreateProductCategoryRequest;
import com.tunahan.market.dtos.responses.category.CreateCategoryResponse;
import com.tunahan.market.dtos.responses.category.GetAllCategoryResponse;
import com.tunahan.market.dtos.responses.category.GetCategoryResponse;

public interface CategoryService {

	DataResult<List<GetAllCategoryResponse>> getAll();
	DataResult<GetCategoryResponse> getById(long id);
	DataResult<GetCategoryResponse> getByName(String name);
	DataResult<CreateCategoryResponse> add(CreateCategoryRequest createRequest); 
	Result addProductToCategory(CreateProductCategoryRequest request);
	DataResult<List<Long>> getAllProductsById(long categoryId);
}
