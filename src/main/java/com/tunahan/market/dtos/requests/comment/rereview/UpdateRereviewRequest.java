package com.tunahan.market.dtos.requests.comment.rereview;

import org.hibernate.validator.constraints.Length;

import com.tunahan.market.core.constant.comment.RereviewConstants;

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
public class UpdateRereviewRequest {

	@Positive
	private long id;
	
	@Positive
	private long reviewId;
	
	@Positive
	private long customerId;
	
	@NotNull(message="{rereview.nullName}")
	@Length(min = RereviewConstants.minLengthRereview,
	        max = RereviewConstants.maxLengthRereview,
	        message = "{rereview.lengthName}")
	private String comment;
}
