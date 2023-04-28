package com.tunahan.market.business.concretes.category;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.tunahan.market.business.abstracts.category.CategoryService;
import com.tunahan.market.business.abstracts.intermediate.ProductCategoryService;
import com.tunahan.market.business.abstracts.product.ProductService;
import com.tunahan.market.core.utilities.mapping.ModelMapperService;
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

	@Override
	public void addProductToCategory(CreateProductCategoryRequest request) {
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
	}

	@Override
	public List<Long> getAllProductsById(long categoryId){
		return categoryRepository.findAllProductsById(categoryId);
	}
	
}
