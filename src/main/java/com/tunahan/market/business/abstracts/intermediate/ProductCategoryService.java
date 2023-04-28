package com.tunahan.market.business.abstracts.intermediate;

import java.util.List;

import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.core.utilities.result.Result;
import com.tunahan.market.dtos.responses.intermediate.GetAllProductCategoryResponse;
import com.tunahan.market.entities.intermediate.ProductCategory;

public interface ProductCategoryService {
	
	DataResult<List<GetAllProductCategoryResponse>>  getAll();
	Result add(ProductCategory productCategory);
}
