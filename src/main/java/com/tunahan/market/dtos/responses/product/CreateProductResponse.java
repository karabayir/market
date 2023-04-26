package com.tunahan.market.dtos.responses.product;

public record CreateProductResponse(
		long id, 
		String name,
		String description,
		String image,
		double unitPrice,
		double unitsInStock
		) {

}
