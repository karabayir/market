package com.tunahan.market.dtos.responses.product;

public record GetAllProductResponse(
		long id, 
		String name,
		String description,
		String image,
		double unitPrice,
		double unitsInStock
		) {

}
