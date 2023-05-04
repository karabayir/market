package com.tunahan.market.business.abstracts.category;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.dtos.requests.category.CreateCategoryRequest;
import com.tunahan.market.dtos.requests.category.UpdateCategoryRequest;
import com.tunahan.market.dtos.responses.category.CreateCategoryResponse;
import com.tunahan.market.dtos.responses.category.GetAllCategoryResponse;
import com.tunahan.market.dtos.responses.category.GetCategoryResponse;
import com.tunahan.market.dtos.responses.category.UpdateCategoryResponse;

public interface CategoryService {

	DataResult<List<GetAllCategoryResponse>> getAll();
	DataResult<GetCategoryResponse> getById(long id);
	DataResult<GetCategoryResponse> getByName(String name);
	DataResult<CreateCategoryResponse> add(CreateCategoryRequest request); 
	DataResult<UpdateCategoryResponse> update(UpdateCategoryRequest request);
	DataResult<Slice<GetAllCategoryResponse>> getAllPagination(Pageable pageable);
}
