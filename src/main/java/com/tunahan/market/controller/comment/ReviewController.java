package com.tunahan.market.controller.comment;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tunahan.market.business.abstracts.comment.ReviewService;
import com.tunahan.market.core.messages.comment.ReviewMessages;
import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.core.utilities.result.Result;
import com.tunahan.market.dtos.requests.comment.review.CreateReviewRequest;
import com.tunahan.market.dtos.requests.comment.review.UpdateReviewRequest;
import com.tunahan.market.dtos.responses.comment.review.CreateReviewResponse;
import com.tunahan.market.dtos.responses.comment.review.GetAllReviewResponse;
import com.tunahan.market.dtos.responses.comment.review.GetReviewResponse;
import com.tunahan.market.dtos.responses.comment.review.UpdateReviewResponse;
import com.tunahan.market.entities.comment.Review;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = ReviewMessages.Controller.requestMapping)
@AllArgsConstructor
public class ReviewController {

	private final ReviewService reviewService;
	
	@GetMapping(path = ReviewMessages.Controller.getAll)
	DataResult<List<GetAllReviewResponse>> getAll(){
		return reviewService.getAll();
	}
	
	@GetMapping(path = ReviewMessages.Controller.getById)
	DataResult<GetReviewResponse> getById(@PathVariable long id){
		return reviewService.getById(id);
	}
	
	@PostMapping(path = ReviewMessages.Controller.add)
	DataResult<CreateReviewResponse> add(@Valid @RequestBody CreateReviewRequest request){
		return reviewService.add(request);
	}
	
	@PutMapping(path = ReviewMessages.Controller.update)
	DataResult<UpdateReviewResponse> update(@Valid @RequestBody UpdateReviewRequest request){
		return reviewService.update(request);
	}
	
	@GetMapping(path = ReviewMessages.Controller.pageable)
	DataResult<Page<Review>> getAllPageable(@RequestParam int number, @RequestParam int size){
		return reviewService.getAllPageable(number, size);
	}
	
	@DeleteMapping(path = ReviewMessages.Controller.deleteById)
	Result delete(long id) {
		return reviewService.delete(id);
	}
}
