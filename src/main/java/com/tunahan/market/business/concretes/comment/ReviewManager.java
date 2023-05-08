package com.tunahan.market.business.concretes.comment;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tunahan.market.business.abstracts.comment.ReviewService;
import com.tunahan.market.core.messages.comment.ReviewMessages;
import com.tunahan.market.core.utilities.mapping.ModelMapperService;
import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.core.utilities.result.Result;
import com.tunahan.market.core.utilities.result.SuccessDataResult;
import com.tunahan.market.core.utilities.result.SuccessResult;
import com.tunahan.market.dtos.requests.comment.review.CreateReviewRequest;
import com.tunahan.market.dtos.requests.comment.review.UpdateReviewRequest;
import com.tunahan.market.dtos.responses.comment.review.CreateReviewResponse;
import com.tunahan.market.dtos.responses.comment.review.GetAllReviewResponse;
import com.tunahan.market.dtos.responses.comment.review.GetReviewResponse;
import com.tunahan.market.dtos.responses.comment.review.UpdateReviewResponse;
import com.tunahan.market.entities.comment.Review;
import com.tunahan.market.repository.comment.ReviewRepository;
import com.tunahan.market.rules.comment.ReviewRules;
import com.tunahan.market.rules.customer.CustomerRules;
import com.tunahan.market.rules.product.ProductRules;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReviewManager implements ReviewService{
	
	private final ReviewRepository reviewRepository;
	private final ModelMapperService mapperService;
	private final ReviewRules rules;
	private final ProductRules productRules;
	private final CustomerRules customerRules;
	

	@Override
	public DataResult<List<GetAllReviewResponse>> getAll() {
		List<GetAllReviewResponse> result = reviewRepository.findAll()
				.stream()
				.map(r -> mapperService.forResponse().map(r, GetAllReviewResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllReviewResponse>>(result,ReviewMessages.Result.getAllReview);
	}

	@Override
	public DataResult<GetReviewResponse> getById(long id) {
		rules.checkIfReviewExists(id);
		Review  review = reviewRepository.findById(id).orElseThrow();
		GetReviewResponse result = mapperService.forResponse().map(review, GetReviewResponse.class);
		return new SuccessDataResult<GetReviewResponse>(result,ReviewMessages.Result.getReviewById);
	}

	@Override
	public DataResult<CreateReviewResponse> add(CreateReviewRequest request) {
		productRules.checkIfProductExists(request.getProductId());
		customerRules.checkIfCustomerExists(request.getCustomerId());
		Review review = mapperService.forRequest().map(request, Review.class);
		review.setId(0);
		rules.checkIfReviewSlang(review);
		reviewRepository.save(review);
		CreateReviewResponse result = mapperService.forResponse().map(review, CreateReviewResponse.class);
		return new SuccessDataResult<CreateReviewResponse>(result,ReviewMessages.Result.addReview);
	}

	@Override
	public DataResult<UpdateReviewResponse> update(UpdateReviewRequest request) {
		rules.checkIfReviewExists(request.getId());
		productRules.checkIfProductExists(request.getProductId());
		customerRules.checkIfCustomerExists(request.getCustomerId());
		Review review = mapperService.forRequest().map(request, Review.class);
		rules.checkIfReviewSlang(review);
		reviewRepository.save(review);
		UpdateReviewResponse result = mapperService.forResponse().map(review, UpdateReviewResponse.class);
		return new SuccessDataResult<UpdateReviewResponse>(result,ReviewMessages.Result.updateReview);
	}

	@Override
	public DataResult<Page<Review>> getAllPageable(int number, int size) {
		Pageable pageable = PageRequest.of(number, size);
		Page<Review> result = reviewRepository.findAll(pageable);
		return new SuccessDataResult<Page<Review>>(result,ReviewMessages.Result.getAllReviewPageable);
	}

	@Override
	public Result delete(long id) {
		rules.checkIfReviewExists(id);
		reviewRepository.deleteById(id);
		return new SuccessResult(ReviewMessages.Result.deleteReview);
	}

}
