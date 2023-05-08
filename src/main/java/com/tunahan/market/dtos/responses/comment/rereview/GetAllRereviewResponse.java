package com.tunahan.market.dtos.responses.comment.rereview;

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
public class GetAllRereviewResponse {

	private long id;
	private long reviewId;
	private long customerId;
	private String comment;
	private CommentStatus commentStatus;
	private LocalDate date;
}
