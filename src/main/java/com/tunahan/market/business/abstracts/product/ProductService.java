package com.tunahan.market.business.abstracts.product;

import java.util.List;

import com.tunahan.market.dtos.requests.product.CreateProductRequest;
import com.tunahan.market.dtos.responses.product.CreateProductResponse;
import com.tunahan.market.dtos.responses.product.GetAllProductResponse;
import com.tunahan.market.dtos.responses.product.GetProductResponse;

public interface ProductService {

	List<GetAllProductResponse> getAll();
	GetProductResponse getById(long id);
	List<GetAllProductResponse> getByName(String name);
	CreateProductResponse add(CreateProductRequest createRequest);
	
	
}
