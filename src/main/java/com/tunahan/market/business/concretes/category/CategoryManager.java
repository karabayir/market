package com.tunahan.market.business.concretes.category;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tunahan.market.business.abstracts.category.CategoryService;
import com.tunahan.market.core.utilities.mapping.ModelMapperService;
import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.core.utilities.result.Result;
import com.tunahan.market.core.utilities.result.SuccessDataResult;
import com.tunahan.market.core.utilities.result.SuccessResult;
import com.tunahan.market.dtos.requests.category.CreateCategoryRequest;
import com.tunahan.market.dtos.requests.category.UpdateCategoryRequest;
import com.tunahan.market.dtos.responses.category.CreateCategoryResponse;
import com.tunahan.market.dtos.responses.category.GetAllCategoryResponse;
import com.tunahan.market.dtos.responses.category.GetCategoryResponse;
import com.tunahan.market.dtos.responses.category.UpdateCategoryResponse;
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
	public DataResult<List<GetAllCategoryResponse>> getAll() {
		List<GetAllCategoryResponse> result= categoryRepository.findAll()
				.stream()
				.map(c -> mapperService.forResponse().map(c, GetAllCategoryResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllCategoryResponse>>(result, "getAll");
	}

	@Override
	public DataResult<GetCategoryResponse> getById(long id) {
		rules.checkIfCategoryExists(id);
		Category category = categoryRepository.findById(id).orElseThrow();
		GetCategoryResponse result= mapperService.forResponse().map(category, GetCategoryResponse.class);
		return new SuccessDataResult<GetCategoryResponse>(result, "getById");
	}

	@Override
	public DataResult<GetCategoryResponse> getByName(String name) {
		rules.checkIfCategoryExists(name);
		Category category = categoryRepository.findByNameIgnoreCase(name).orElseThrow();
		GetCategoryResponse result= mapperService.forResponse().map(category, GetCategoryResponse.class);
		return new SuccessDataResult<GetCategoryResponse>(result, "getByName");
	}

	@Override
	public DataResult<CreateCategoryResponse> add(CreateCategoryRequest request) {
		rules.checkIfCategoryNameExists(request.getName());
		Category category = mapperService.forRequest().map(request,Category.class);
		categoryRepository.save(category);
		CreateCategoryResponse result= mapperService.forResponse().map(category, CreateCategoryResponse.class);
		return new SuccessDataResult<CreateCategoryResponse>(result, "add");
	}

	@Override
	public DataResult<UpdateCategoryResponse> update(UpdateCategoryRequest request) {
		rules.checkIfCategoryExists(request.getId());
		Category category = mapperService.forRequest().map(request, Category.class);
		categoryRepository.save(category);
		UpdateCategoryResponse result = mapperService.forResponse().map(category, UpdateCategoryResponse.class);
		return new SuccessDataResult<UpdateCategoryResponse>(result, "update");
	}

	@Override
	public Result delete(long id) {
		rules.checkIfCategoryExists(id);
		categoryRepository.deleteById(id);
		return new SuccessResult("delete");
	}

	@Override
	public DataResult<Page<Category>> getAllPageable(int number, int size) {
		Pageable pageable = PageRequest.of(number, size);
		Page<Category> result = categoryRepository.findAll(pageable);
		return new SuccessDataResult<Page<Category>>(result, "getAllPagable");
	}
	
}
