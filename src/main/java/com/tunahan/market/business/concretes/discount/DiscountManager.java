package com.tunahan.market.business.concretes.discount;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tunahan.market.business.abstracts.discount.DiscountService;
import com.tunahan.market.core.utilities.mapping.ModelMapperService;
import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.core.utilities.result.Result;
import com.tunahan.market.core.utilities.result.SuccessDataResult;
import com.tunahan.market.core.utilities.result.SuccessResult;
import com.tunahan.market.dtos.requests.discount.CreateDiscountRequest;
import com.tunahan.market.dtos.requests.discount.UpdateDiscountRequest;
import com.tunahan.market.dtos.responses.discount.CreateDiscountResponse;
import com.tunahan.market.dtos.responses.discount.GetAllDiscountResponse;
import com.tunahan.market.dtos.responses.discount.GetDiscountResponse;
import com.tunahan.market.dtos.responses.discount.UpdateDiscountResponse;
import com.tunahan.market.entities.preOrder.Discount;
import com.tunahan.market.repository.preOrder.DiscountRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DiscountManager implements DiscountService{
	
	private final DiscountRepository discountRepository;
	private final ModelMapperService mapperService;

	@Override
	public DataResult<List<GetAllDiscountResponse>> getAll() {
		List<GetAllDiscountResponse> result =  discountRepository.findAll()
				.stream()
				.map(d -> mapperService.forResponse().map(d, GetAllDiscountResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllDiscountResponse>>(result, "getAll");
	}

	@Override
	public DataResult<GetDiscountResponse> getById(long id) {
		Discount discount = discountRepository.findById(id).orElseThrow();
		GetDiscountResponse result = mapperService.forResponse().map(discount, GetDiscountResponse.class);
		return new SuccessDataResult<GetDiscountResponse>(result, "getById");
	}

	@Override
	public DataResult<GetDiscountResponse> getByName(String name) {
		Discount discount = discountRepository.findByNameIgnoreCase(name).orElseThrow();
		GetDiscountResponse result = mapperService.forResponse().map(discount, GetDiscountResponse.class);
		return new SuccessDataResult<GetDiscountResponse>(result, "getByName");
	}

	@Override
	public DataResult<CreateDiscountResponse> add(CreateDiscountRequest request) {
		Discount discount = mapperService.forRequest().map(request, Discount.class);
		discount.setId(0);
		discountRepository.save(discount);
		CreateDiscountResponse result = mapperService.forResponse().map(discount, CreateDiscountResponse.class);
		return new SuccessDataResult<CreateDiscountResponse>(result, "add");
	}

	@Override
	public DataResult<UpdateDiscountResponse> update(UpdateDiscountRequest request) {
		Discount discount = mapperService.forRequest().map(request, Discount.class);
		discountRepository.save(discount);
		UpdateDiscountResponse result = mapperService.forResponse().map(discount, UpdateDiscountResponse.class);
		return new SuccessDataResult<UpdateDiscountResponse>(result, "update");
	}

	@Override
	public DataResult<Page<Discount>> getAllPageable(int number, int size) {
		Pageable pageable = PageRequest.of(number, size);
		Page<Discount> result = discountRepository.findAll(pageable);
		return new SuccessDataResult<Page<Discount>>(result, "getAllPageable");
	}

	@Override
	public Result delete(long id) {
		discountRepository.deleteById(id);
		return new SuccessResult("delete");
	}

}
