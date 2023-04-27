package com.tunahan.market.business.abstracts.intermediate;

import java.util.List;

import com.tunahan.market.dtos.responses.intermediate.GetAllProductCategoryResponse;
import com.tunahan.market.entities.intermediate.ProductCategory;

public interface ProductCategoryService {
	
	List<GetAllProductCategoryResponse> getAll();
	void add(ProductCategory productCategory);
}
