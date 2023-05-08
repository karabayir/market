package com.tunahan.market.dtos.requests.discount;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tunahan.market.core.constant.discount.DiscountConstants;

import jakarta.validation.constraints.Max;
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
public class UpdateDiscountRequest {
	
	@Positive
	private long id;
	
	@Positive
	private long productId;
	
	@NotNull(message = "{discount.nullName}")
	@Length(min = DiscountConstants.minLengthName,
	        max = DiscountConstants.maxLengthName,
	        message = "{discount.lengthName}")
	private String name;
	
	@Positive
	@Max(value = DiscountConstants.maxRate,
	     message = "{discount.maximumRate}")
	private double rate;
	
	@NotNull(message = "{discount.nullEndDate}")
	@JsonFormat(pattern = "dd.MM.yyyy")
	private LocalDate endDate;
}
