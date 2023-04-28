package com.tunahan.market.business.abstracts.product;

import java.util.List;

import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.core.utilities.result.Result;
import com.tunahan.market.dtos.requests.intermediate.CreateProductCategoryRequest;
import com.tunahan.market.dtos.requests.product.CreateProductRequest;
import com.tunahan.market.dtos.responses.product.CreateProductResponse;
import com.tunahan.market.dtos.responses.product.GetAllProductResponse;
import com.tunahan.market.dtos.responses.product.GetProductResponse;

public interface ProductService {

	DataResult<List<GetAllProductResponse>> getAll();
	DataResult<GetProductResponse> getById(long id);
	DataResult<List<GetAllProductResponse>> getByName(String name);
	DataResult<CreateProductResponse> add(CreateProductRequest createRequest);
	Result addCategoryToProduct(CreateProductCategoryRequest request);
	DataResult<List<Long>> getAllCategoriesById(long productId);
	
}
