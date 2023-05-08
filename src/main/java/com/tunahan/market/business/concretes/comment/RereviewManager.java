package com.tunahan.market.business.concretes.comment;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tunahan.market.business.abstracts.comment.RereviewService;
import com.tunahan.market.core.messages.comment.RereviewMessages;
import com.tunahan.market.core.utilities.mapping.ModelMapperService;
import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.core.utilities.result.Result;
import com.tunahan.market.core.utilities.result.SuccessDataResult;
import com.tunahan.market.core.utilities.result.SuccessResult;
import com.tunahan.market.dtos.requests.comment.rereview.CreateRereviewRequest;
import com.tunahan.market.dtos.requests.comment.rereview.UpdateRereviewRequest;
import com.tunahan.market.dtos.responses.comment.rereview.CreateRereviewResponse;
import com.tunahan.market.dtos.responses.comment.rereview.GetAllRereviewResponse;
import com.tunahan.market.dtos.responses.comment.rereview.GetRereviewResponse;
import com.tunahan.market.dtos.responses.comment.rereview.UpdateRereviewResponse;
import com.tunahan.market.entities.comment.Rereview;
import com.tunahan.market.repository.comment.RereviewRepository;
import com.tunahan.market.rules.comment.RereviewRules;
import com.tunahan.market.rules.comment.ReviewRules;
import com.tunahan.market.rules.customer.CustomerRules;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RereviewManager implements RereviewService{
	
	private final RereviewRepository rereviewRepository;
	private final ModelMapperService mapperService;
	private final RereviewRules rules;
	private final CustomerRules customerRules;
	private final ReviewRules reviewRules;

	@Override
	public DataResult<List<GetAllRereviewResponse>> getAll() {
		List<GetAllRereviewResponse> result = rereviewRepository.findAll()
				.stream()
				.map(rr -> mapperService.forResponse().map(rr, GetAllRereviewResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllRereviewResponse>>(result,RereviewMessages.Result.getAllRereview);
	}

	@Override
	public DataResult<GetRereviewResponse> getById(long id) {
		rules.checkIfReviewExists(id);
		Rereview rereview = rereviewRepository.findById(id).orElseThrow();
		GetRereviewResponse result = mapperService.forResponse().map(rereview, GetRereviewResponse.class);
		return new SuccessDataResult<GetRereviewResponse>(result,RereviewMessages.Result.getRereviewById);
	}

	@Override
	public DataResult<CreateRereviewResponse> add(CreateRereviewRequest request) {
		customerRules.checkIfCustomerExists(request.getCustomerId());
		reviewRules.checkIfReviewExists(request.getReviewId());
		Rereview rereview = mapperService.forRequest().map(request, Rereview.class);
		rereview.setId(0);
		rules.checkIfReviewSlang(rereview);
		rereviewRepository.save(rereview);
		CreateRereviewResponse result = mapperService.forResponse().map(rereview, CreateRereviewResponse.class);
		return new SuccessDataResult<CreateRereviewResponse>(result,RereviewMessages.Result.addRereview);
	}

	@Override
	public DataResult<UpdateRereviewResponse> update(UpdateRereviewRequest request) {
		rules.checkIfReviewExists(request.getId());
		customerRules.checkIfCustomerExists(request.getCustomerId());
		reviewRules.checkIfReviewExists(request.getReviewId());
		Rereview rereview = mapperService.forRequest().map(request, Rereview.class);
		rules.checkIfReviewSlang(rereview);
		rereviewRepository.save(rereview);
		UpdateRereviewResponse result = mapperService.forResponse().map(rereview, UpdateRereviewResponse.class);
		return new SuccessDataResult<UpdateRereviewResponse>(result,RereviewMessages.Result.updateRereview);
	}

	@Override
	public DataResult<Page<Rereview>> getAllPageable(int number, int size) {
		Pageable pageable = PageRequest.of(number, size);
		Page<Rereview> result = rereviewRepository.findAll(pageable);
		return new SuccessDataResult<Page<Rereview>>(result,RereviewMessages.Result.getAllRereviewPageable);
	}

	@Override
	public Result delete(long id) {
		rules.checkIfReviewExists(id);
		rereviewRepository.deleteById(id);
		return new SuccessResult(RereviewMessages.Result.deleteRereview);
	}

}
