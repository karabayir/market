package com.tunahan.market.business.abstracts.seller;

import java.util.List;

import org.springframework.data.domain.Page;

import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.core.utilities.result.Result;
import com.tunahan.market.dtos.requests.seller.CreateSellerRequest;
import com.tunahan.market.dtos.requests.seller.UpdateSellerRequest;
import com.tunahan.market.dtos.responses.seller.CreateSellerResponse;
import com.tunahan.market.dtos.responses.seller.GetAllSellerResponse;
import com.tunahan.market.dtos.responses.seller.GetSellerResponse;
import com.tunahan.market.dtos.responses.seller.UpdateSellerResponse;
import com.tunahan.market.entities.seller.Seller;

public interface SellerService {

	DataResult<List<GetAllSellerResponse>> getAll();
	DataResult<GetSellerResponse> getById(long id);
	DataResult<GetSellerResponse> getByTaxNumber(String number);
	DataResult<List<GetSellerResponse>> getByName(String name);
	DataResult<CreateSellerResponse> add(CreateSellerRequest request);
	DataResult<UpdateSellerResponse> update(UpdateSellerRequest request);
	DataResult<Page<Seller>> getAllPageable(int number, int size);
	Result delete(long id);
}
