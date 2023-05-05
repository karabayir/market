package com.tunahan.market.business.abstracts.product;

import java.util.List;

import org.springframework.data.domain.Page;

import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.core.utilities.result.Result;
import com.tunahan.market.dtos.requests.product.CreateProductRequest;
import com.tunahan.market.dtos.requests.product.UpdateProductRequest;
import com.tunahan.market.dtos.responses.product.CreateProductResponse;
import com.tunahan.market.dtos.responses.product.GetAllProductResponse;
import com.tunahan.market.dtos.responses.product.GetProductResponse;
import com.tunahan.market.dtos.responses.product.UpdateProductResponse;
import com.tunahan.market.entities.product.Product;

public interface ProductService {

	DataResult<List<GetAllProductResponse>> getAll();
	DataResult<GetProductResponse> getById(long id);
	DataResult<List<GetAllProductResponse>> getByName(String name);
	DataResult<CreateProductResponse> add(CreateProductRequest request);
	DataResult<UpdateProductResponse> update(UpdateProductRequest request);
	DataResult<Page<Product>> getAllPageable(int number, int size);
	Result delete(long id);
}
