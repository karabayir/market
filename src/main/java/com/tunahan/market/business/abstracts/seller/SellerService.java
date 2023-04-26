package com.tunahan.market.business.abstracts.seller;

import java.util.List;

import com.tunahan.market.dtos.requests.seller.CreateSellerRequest;
import com.tunahan.market.dtos.responses.seller.CreateSellerResponse;
import com.tunahan.market.dtos.responses.seller.GetAllSellerResponse;
import com.tunahan.market.dtos.responses.seller.GetSellerResponse;

public interface SellerService {

	List<GetAllSellerResponse> getAll();
	GetSellerResponse getById(long id);
	List<GetSellerResponse> getByName(String name);
	CreateSellerResponse add(CreateSellerRequest createRequest);
}
