package com.tunahan.market.business.abstracts.comment;

import java.util.List;

import org.springframework.data.domain.Page;

import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.core.utilities.result.Result;
import com.tunahan.market.dtos.requests.comment.review.CreateReviewRequest;
import com.tunahan.market.dtos.requests.comment.review.UpdateReviewRequest;
import com.tunahan.market.dtos.responses.comment.review.CreateReviewResponse;
import com.tunahan.market.dtos.responses.comment.review.GetAllReviewResponse;
import com.tunahan.market.dtos.responses.comment.review.GetReviewResponse;
import com.tunahan.market.dtos.responses.comment.review.UpdateReviewResponse;
import com.tunahan.market.entities.comment.Review;

public interface ReviewService {

	DataResult<List<GetAllReviewResponse>> getAll();
	DataResult<GetReviewResponse> getById(long id);
	DataResult<CreateReviewResponse> add(CreateReviewRequest request);
	DataResult<UpdateReviewResponse> update(UpdateReviewRequest request);
	DataResult<Page<Review>> getAllPageable(int number, int size);
	Result delete(long id);
}
