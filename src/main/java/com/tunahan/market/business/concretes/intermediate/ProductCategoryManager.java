package com.tunahan.market.business.concretes.intermediate;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tunahan.market.business.abstracts.intermediate.ProductCategoryService;
import com.tunahan.market.core.utilities.mapping.ModelMapperService;
import com.tunahan.market.dtos.responses.intermediate.GetAllProductCategoryResponse;
import com.tunahan.market.entities.intermediate.ProductCategory;
import com.tunahan.market.repository.intermediate.ProductCategoryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductCategoryManager implements ProductCategoryService{

	private final ProductCategoryRepository repository;
	private final ModelMapperService mapperService;

	@Override
	public List<GetAllProductCategoryResponse> getAll() {
		return repository.findAll()
				.stream()
				.map(pc -> mapperService.forResponse().map(pc, GetAllProductCategoryResponse.class))
				.collect(Collectors.toList());
	}

	@Override
	public void add(ProductCategory productCategory) {
		repository.save(productCategory);
	}
}
