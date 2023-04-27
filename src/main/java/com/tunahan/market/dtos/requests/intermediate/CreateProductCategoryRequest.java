package com.tunahan.market.dtos.requests.intermediate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductCategoryRequest {

	private long categoryId;
	private long productId;
	
}
