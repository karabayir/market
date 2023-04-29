package com.tunahan.market.business.abstracts.customer;

import java.util.List;

import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.dtos.requests.customer.CreateCorporateCustomerRequest;
import com.tunahan.market.dtos.responses.customer.corporate.CreateCorporateCustomerResponse;
import com.tunahan.market.dtos.responses.customer.corporate.GetAllCorporateCustomerResponse;
import com.tunahan.market.dtos.responses.customer.corporate.GetCorporateCustomerResponse;

public interface CorporateCustomerService {

	DataResult<List<GetAllCorporateCustomerResponse>> getAll();
	DataResult<GetCorporateCustomerResponse> getById(long id);
	DataResult<List<GetCorporateCustomerResponse>> getByName(String name);
	DataResult<GetCorporateCustomerResponse> getByTaxNumber(String taxNumber);
	DataResult<CreateCorporateCustomerResponse> add(CreateCorporateCustomerRequest request);
}
