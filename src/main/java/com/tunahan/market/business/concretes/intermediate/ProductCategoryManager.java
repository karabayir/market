package com.tunahan.market.business.concretes.intermediate;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tunahan.market.business.abstracts.intermediate.ProductCategoryService;
import com.tunahan.market.core.utilities.mapping.ModelMapperService;
import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.core.utilities.result.Result;
import com.tunahan.market.core.utilities.result.SuccessDataResult;
import com.tunahan.market.core.utilities.result.SuccessResult;
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
	public DataResult<List<GetAllProductCategoryResponse>> getAll() {
		List<GetAllProductCategoryResponse> result= repository.findAll()
				.stream()
				.map(pc -> mapperService.forResponse().map(pc, GetAllProductCategoryResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllProductCategoryResponse>>(result, "getAll");
	}

	@Override
	public Result add(ProductCategory productCategory) {
		repository.save(productCategory);
		return new SuccessResult("add");
	}
}
