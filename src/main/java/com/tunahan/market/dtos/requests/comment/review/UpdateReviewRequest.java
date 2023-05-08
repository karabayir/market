package com.tunahan.market.dtos.requests.comment.review;


import org.hibernate.validator.constraints.Length;

import com.tunahan.market.core.constant.comment.ReviewConstants;

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
public class UpdateReviewRequest {

	@Positive
	private long id;
	
	@Positive
	private long productId;
	
	@Positive
	private long customerId;
	
	@NotNull(message="{review.nullName}")
	@Length(min=ReviewConstants.minLengthReview,
	        max=ReviewConstants.maxLengthReview,
	        message="{review.lengthName}")
	private String comment;
}
