package com.tunahan.market.business.concretes.category;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tunahan.market.business.abstracts.category.CategoryService;
import com.tunahan.market.core.utilities.mapping.ModelMapperService;
import com.tunahan.market.dtos.requests.category.CreateCategoryRequest;
import com.tunahan.market.dtos.responses.category.CreateCategoryResponse;
import com.tunahan.market.dtos.responses.category.GetAllCategoryResponse;
import com.tunahan.market.dtos.responses.category.GetCategoryResponse;
import com.tunahan.market.entities.category.Category;
import com.tunahan.market.repository.category.CategoryRepository;
import com.tunahan.market.rules.category.CategoryRules;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService{

	private final CategoryRepository categoryRepository;
	private final ModelMapperService mapperService;
	private final CategoryRules rules;

	@Override
	public List<GetAllCategoryResponse> getAll() {
		return categoryRepository.findAll()
				.stream()
				.map(c -> mapperService.forResponse().map(c, GetAllCategoryResponse.class))
				.collect(Collectors.toList());
	}

	@Override
	public GetCategoryResponse getById(long id) {
		rules.checkIfCategoryExists(id);
		Category category = categoryRepository.findById(id).orElseThrow();
		return mapperService.forResponse().map(category, GetCategoryResponse.class);
	}

	@Override
	public GetCategoryResponse getByName(String name) {
		rules.checkIfCategoryExists(name);
		Category category = categoryRepository.findByName(name).orElseThrow();
		return mapperService.forResponse().map(category, GetCategoryResponse.class);
	}

	@Override
	public CreateCategoryResponse add(CreateCategoryRequest createRequest) {
		Category category = mapperService.forRequest().map(createRequest,Category.class);
		categoryRepository.save(category);
		return mapperService.forResponse().map(category, CreateCategoryResponse.class);
	}
	
	
}
