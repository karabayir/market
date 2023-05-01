package com.tunahan.market.business.concretes.product;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tunahan.market.business.abstracts.product.ProductService;
import com.tunahan.market.core.utilities.mapping.ModelMapperService;
import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.core.utilities.result.SuccessDataResult;
import com.tunahan.market.dtos.requests.product.CreateProductRequest;
import com.tunahan.market.dtos.requests.product.UpdateProductRequest;
import com.tunahan.market.dtos.responses.product.CreateProductResponse;
import com.tunahan.market.dtos.responses.product.GetAllProductResponse;
import com.tunahan.market.dtos.responses.product.GetProductResponse;
import com.tunahan.market.dtos.responses.product.UpdateProductResponse;
import com.tunahan.market.entities.product.Product;
import com.tunahan.market.repository.product.ProductRepository;
import com.tunahan.market.rules.product.ProductRules;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService{
	
	private final ProductRepository productRepository;
	private final ModelMapperService mapperService;
	private final ProductRules rules;
	
	@Override
	public DataResult<List<GetAllProductResponse>> getAll() {
		List<GetAllProductResponse> result= productRepository.findAll()
				.stream()
				.map(p -> mapperService.forResponse().map(p, GetAllProductResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllProductResponse>>(result, "getAll");
	}

	@Override
	public DataResult<GetProductResponse> getById(long id) {
		rules.checkIfProductExists(id);
		Product product = productRepository.findById(id).orElseThrow();
		GetProductResponse result= mapperService.forResponse().map(product, GetProductResponse.class);
		return new SuccessDataResult<GetProductResponse>(result, "getById");
	}

	@Override
	public DataResult<List<GetAllProductResponse>> getByName(String name) {
		rules.checkIfProductExists(name);
		List<GetAllProductResponse> result= productRepository.findByNameIgnoreCase(name)
				.stream()
				.map(p -> mapperService.forResponse().map(p, GetAllProductResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllProductResponse>>(result, "getByName");
	}

	@Override
	public DataResult<CreateProductResponse> add(CreateProductRequest request) {
		Product product = mapperService.forRequest().map(request, Product.class);
		product.setId(0);
		productRepository.save(product);
		CreateProductResponse result= mapperService.forResponse().map(product, CreateProductResponse.class);
		return new SuccessDataResult<CreateProductResponse>(result, "add");
	}

	@Override
	public DataResult<UpdateProductResponse> update(UpdateProductRequest request) {
		Product product = mapperService.forRequest().map(request, Product.class);
		productRepository.save(product);	
		UpdateProductResponse result = mapperService.forResponse().map(product, UpdateProductResponse.class);
		return new SuccessDataResult<UpdateProductResponse>(result, "update");
	}
	
}
