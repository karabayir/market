package com.tunahan.market.business.concretes.product;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tunahan.market.business.abstracts.category.CategoryService;
import com.tunahan.market.business.abstracts.intermediate.ProductCategoryService;
import com.tunahan.market.business.abstracts.product.ProductService;
import com.tunahan.market.core.utilities.mapping.ModelMapperService;
import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.core.utilities.result.Result;
import com.tunahan.market.core.utilities.result.SuccessDataResult;
import com.tunahan.market.core.utilities.result.SuccessResult;
import com.tunahan.market.dtos.requests.intermediate.CreateProductCategoryRequest;
import com.tunahan.market.dtos.requests.product.CreateProductRequest;
import com.tunahan.market.dtos.responses.product.CreateProductResponse;
import com.tunahan.market.dtos.responses.product.GetAllProductResponse;
import com.tunahan.market.dtos.responses.product.GetProductResponse;
import com.tunahan.market.entities.category.Category;
import com.tunahan.market.entities.intermediate.ProductCategory;
import com.tunahan.market.entities.product.Product;
import com.tunahan.market.repository.product.ProductRepository;
import com.tunahan.market.rules.category.CategoryRules;
import com.tunahan.market.rules.product.ProductRules;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService{
	
	private final ProductRepository productRepository;
	private final ModelMapperService mapperService;
	private final ProductRules rules;
	private final CategoryRules categoryRules;
	private final ProductCategoryService productCategoryService;
	private final CategoryService categoryService;
	
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
		List<GetAllProductResponse> result= productRepository.findByName(name)
				.stream()
				.map(p -> mapperService.forResponse().map(p, GetAllProductResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllProductResponse>>(result, "getByName");
	}

	@Override
	public DataResult<CreateProductResponse> add(CreateProductRequest createRequest) {
		Product product = mapperService.forRequest().map(createRequest, Product.class);
		productRepository.save(product);
		CreateProductResponse result= mapperService.forResponse().map(product, CreateProductResponse.class);
		return new SuccessDataResult<CreateProductResponse>(result, "add");
	}

	@Override
	public Result addCategoryToProduct(CreateProductCategoryRequest request) {
		rules.checkIfProductExists(request.getProductId());
		categoryRules.checkIfCategoryExists(request.getCategoryId());
		Product product = productRepository.findById(request.getProductId()).orElseThrow();
		Category category = mapperService.forResponse().map(categoryService.getById(request.getCategoryId()), Category.class);
		ProductCategory productCategory = new ProductCategory();
		productCategory.setProduct(product);
		productCategory.setCategory(category);
		product.getProductCategoryList().add(productCategory);
		productRepository.save(product);
		productCategoryService.add(productCategory);
		return new SuccessResult("addCategoryToProduct");
	}

	@Override
	public DataResult<List<Long>> getAllCategoriesById(long productId) {
		rules.checkIfProductExists(productId);
		List<Long> result= productRepository.findAllCategoriesById(productId);
		return new SuccessDataResult<List<Long>>(result, "getAllCategoriesById");
	}

	
}
