package com.tunahan.market.dtos.requests.product;

import org.hibernate.validator.constraints.Length;

import com.tunahan.market.core.constant.product.ProductConstants;
import com.tunahan.market.core.messages.product.ProductMessages;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductRequest {

	@Positive
	private long id;
	
	@Positive
	private long categoryId;
	
	@Positive
	private long colorId;
	
	@Positive
	private long sizeId;
	
	@Positive
	private long sellerId;

	
	@NotNull
	@Length(
			min = ProductConstants.minLengthName, 
			max = ProductConstants.maxLengthName, 
			message = ProductMessages.Validation.lengthProductName)
	private String name;
	
	@NotNull
	@Length(
			max = ProductConstants.maxLengthDescription, 
			message = ProductMessages.Validation.lengthDescription)
	private String description;
	
	private String image;
	
	@Min(
			value = ProductConstants.minUnitPrice,
			message = ProductMessages.Validation.minUnitPrice)
	private double unitPrice;
	
	@Min(
			value = ProductConstants.minStock,
			message = ProductMessages.Validation.minStock)
	private double unitsInStock;
}
