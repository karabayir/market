package com.tunahan.market.dtos.responses.comment.review;

import java.time.LocalDate;

import com.tunahan.market.entities.comment.CommentStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateReviewResponse {

	private long id;
	private long productId;
	private long customerId;
	private String comment;
	private CommentStatus commentStatus;
	private LocalDate date;
}
