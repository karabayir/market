package com.tunahan.market.business.concretes.category;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.tunahan.market.business.abstracts.category.CategoryService;
import com.tunahan.market.business.abstracts.intermediate.ProductCategoryService;
import com.tunahan.market.business.abstracts.product.ProductService;
import com.tunahan.market.core.utilities.mapping.ModelMapperService;
import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.core.utilities.result.Result;
import com.tunahan.market.core.utilities.result.SuccessDataResult;
import com.tunahan.market.core.utilities.result.SuccessResult;
import com.tunahan.market.dtos.requests.category.CreateCategoryRequest;
import com.tunahan.market.dtos.requests.intermediate.CreateProductCategoryRequest;
import com.tunahan.market.dtos.responses.category.CreateCategoryResponse;
import com.tunahan.market.dtos.responses.category.GetAllCategoryResponse;
import com.tunahan.market.dtos.responses.category.GetCategoryResponse;
import com.tunahan.market.entities.category.Category;
import com.tunahan.market.entities.intermediate.ProductCategory;
import com.tunahan.market.entities.product.Product;
import com.tunahan.market.repository.category.CategoryRepository;
import com.tunahan.market.rules.category.CategoryRules;
import com.tunahan.market.rules.product.ProductRules;

@Service
public class CategoryManager implements CategoryService{

	private final CategoryRepository categoryRepository;
	private final ModelMapperService mapperService;
	private final CategoryRules rules;
	private final ProductRules rulesProduct;
	private final ProductService productService;
	private final ProductCategoryService productCategoryService;
	
	//Product ile Category arasındaki döngü oluşmaması için manuel constructor injection kullandık
	//@Lazy anotasyonu ile de ProductService oluşumunu geciktirerek döngüyü engelledik.
	public CategoryManager(
			CategoryRepository categoryRepository, 
			ModelMapperService mapperService, 
			CategoryRules rules,
			ProductRules rulesProduct,
			ProductCategoryService productCategoryService,
			@Lazy ProductService productService
			) {
		this.categoryRepository = categoryRepository;
		this.mapperService = mapperService;
		this.rules = rules;
		this.rulesProduct = rulesProduct;
		this.productCategoryService = productCategoryService;
		this.productService = productService;
	}

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
		Category category = categoryRepository.findByName(name).orElseThrow();
		GetCategoryResponse result= mapperService.forResponse().map(category, GetCategoryResponse.class);
		return new SuccessDataResult<GetCategoryResponse>(result, "getByName");
	}

	@Override
	public DataResult<CreateCategoryResponse> add(CreateCategoryRequest createRequest) {
		rules.checkIfCategoryNameExists(createRequest.getName());
		Category category = mapperService.forRequest().map(createRequest,Category.class);
		categoryRepository.save(category);
		CreateCategoryResponse result= mapperService.forResponse().map(category, CreateCategoryResponse.class);
		return new SuccessDataResult<CreateCategoryResponse>(result, "add");
	}

	@Override
	public Result addProductToCategory(CreateProductCategoryRequest request) {
		rules.checkIfCategoryExists(request.getCategoryId());
		rulesProduct.checkIfProductExists(request.getProductId());
		Category category = categoryRepository.findById(request.getCategoryId()).orElseThrow();
		Product  product = mapperService.forResponse().map(productService.getById(request.getProductId()), Product.class);
		ProductCategory productCategory = new ProductCategory();
		productCategory.setCategory(category);
		productCategory.setProduct(product);
		category.getProductCategoryList().add(productCategory);
		categoryRepository.save(category);
		productCategoryService.add(productCategory);
		return new SuccessResult("addProductToCategory");
	}

	@Override
	public DataResult<List<Long>> getAllProductsById(long categoryId){
		rules.checkIfCategoryExists(categoryId);
		List<Long> result= categoryRepository.findAllProductsById(categoryId);
		return new SuccessDataResult<List<Long>>(result, "getAllProductsById");
	}
	
}
