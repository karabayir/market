package com.tunahan.market.business.abstracts.discount;

import java.util.List;

import org.springframework.data.domain.Page;

import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.core.utilities.result.Result;
import com.tunahan.market.dtos.requests.discount.CreateDiscountRequest;
import com.tunahan.market.dtos.requests.discount.UpdateDiscountRequest;
import com.tunahan.market.dtos.responses.discount.CreateDiscountResponse;
import com.tunahan.market.dtos.responses.discount.GetAllDiscountResponse;
import com.tunahan.market.dtos.responses.discount.GetDiscountResponse;
import com.tunahan.market.dtos.responses.discount.UpdateDiscountResponse;
import com.tunahan.market.entities.preOrder.Discount;

public interface DiscountService {

	DataResult<List<GetAllDiscountResponse>> getAll();
	DataResult<GetDiscountResponse> getById(long id);
	DataResult<GetDiscountResponse> getByName(String name);
	DataResult<CreateDiscountResponse> add(CreateDiscountRequest request);
	DataResult<UpdateDiscountResponse> update(UpdateDiscountRequest request);
	DataResult<Page<Discount>> getAllPageable(int number, int size);
	Result delete(long id);
}
