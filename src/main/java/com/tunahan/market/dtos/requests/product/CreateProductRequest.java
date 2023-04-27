package com.tunahan.market.dtos.requests.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequest{
	private String name;
	private String description;
	private String image;
	private double unitPrice;
	private double unitsInStock;
}
