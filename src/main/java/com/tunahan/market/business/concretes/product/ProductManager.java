package com.tunahan.market.business.concretes.product;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tunahan.market.business.abstracts.product.ProductService;
import com.tunahan.market.core.utilities.mapping.ModelMapperService;
import com.tunahan.market.dtos.requests.product.CreateProductRequest;
import com.tunahan.market.dtos.responses.product.CreateProductResponse;
import com.tunahan.market.dtos.responses.product.GetAllProductResponse;
import com.tunahan.market.dtos.responses.product.GetProductResponse;
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
	public List<GetAllProductResponse> getAll() {
		return productRepository.findAll()
				.stream()
				.map(p -> mapperService.forResponse().map(p, GetAllProductResponse.class))
				.collect(Collectors.toList());
	}

	@Override
	public GetProductResponse getById(long id) {
		rules.checkIfProductExists(id);
		Product product = productRepository.findById(id).orElseThrow();
		return mapperService.forResponse().map(product, GetProductResponse.class);
	}

	@Override
	public List<GetAllProductResponse> getByName(String name) {
		rules.checkIfProductExists(name);
		return productRepository.findByName(name)
				.stream()
				.map(p -> mapperService.forResponse().map(p, GetAllProductResponse.class))
				.collect(Collectors.toList());
	}

	@Override
	public CreateProductResponse add(CreateProductRequest createRequest) {
		Product product = mapperService.forRequest().map(createRequest, Product.class);
		productRepository.save(product);
		return mapperService.forResponse().map(product, CreateProductResponse.class);
	}

	
}
