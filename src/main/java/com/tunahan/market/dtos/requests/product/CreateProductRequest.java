package com.tunahan.market.dtos.requests.product;

public record CreateProductRequest(
		String name,
		String description,
		String image,
		double unitPrice,
		double unitsInStock
		) {

}
