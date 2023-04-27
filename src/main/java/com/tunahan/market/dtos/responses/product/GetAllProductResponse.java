package com.tunahan.market.dtos.responses.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetAllProductResponse{
	
	private long id; 
	private String name;
	private String description;
	private String image;
	private double unitPrice;
	private double unitsInStock;
}
