package com.tunahan.market.dtos.requests.category;

import org.hibernate.validator.constraints.Length;

import com.tunahan.market.core.constant.category.CategoryConstants;
import com.tunahan.market.core.messages.category.CategoryMessages;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCategoryRequest {

	@NotNull(message = CategoryMessages.Validation.nullCategoryName)
	@Length(
			min =CategoryConstants.minLengthName, 
			max = CategoryConstants.maxLengthName, 
			message = CategoryMessages.Validation.lengthCategoryName)
	private String name;
}
