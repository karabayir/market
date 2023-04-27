package com.tunahan.market.dtos.responses.intermediate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetAllProductCategoryResponse{

	private long id;
	private long productId;
	private long categoryId;
}
