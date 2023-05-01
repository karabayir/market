package com.tunahan.market.dtos.responses.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductResponse {
	private long id; 
	private long categoryId;
	private long colorId;
	private long sizeId;
	private long sellerId;
	private String name;
	private String description;
	private String image;
	private double unitPrice;
	private double unitsInStock;
}
