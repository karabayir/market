package com.tunahan.market.dtos.requests.intermediate;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductCategoryRequest {

	@Positive
	private long categoryId;
	
	@Positive
	private long productId;
	
}
