package com.tunahan.market.dtos.responses.comment.review;

import java.time.LocalDate;
import java.util.List;

import com.tunahan.market.dtos.responses.comment.rereview.GetRereviewResponse;
import com.tunahan.market.entities.comment.CommentStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetReviewResponse {

	private long id;
	private long productId;
	private long customerId;
	private String comment;
	private CommentStatus commentStatus;
	private LocalDate date;
	private List<GetRereviewResponse> rereviewList;
}
