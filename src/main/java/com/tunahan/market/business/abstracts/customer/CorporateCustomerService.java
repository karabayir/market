package com.tunahan.market.business.abstracts.customer;

import java.util.List;

import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.dtos.requests.customer.corporate.CreateCorporateCustomerRequest;
import com.tunahan.market.dtos.requests.customer.corporate.UpdateCorporateCustomerRequest;
import com.tunahan.market.dtos.responses.customer.corporate.CreateCorporateCustomerResponse;
import com.tunahan.market.dtos.responses.customer.corporate.GetAllCorporateCustomerResponse;
import com.tunahan.market.dtos.responses.customer.corporate.GetCorporateCustomerResponse;
import com.tunahan.market.dtos.responses.customer.corporate.UpdateCorporateCustomerResponse;

public interface CorporateCustomerService {

	DataResult<List<GetAllCorporateCustomerResponse>> getAll();
	DataResult<GetCorporateCustomerResponse> getById(long id);
	DataResult<List<GetCorporateCustomerResponse>> getByName(String name);
	DataResult<GetCorporateCustomerResponse> getByTaxNumber(String taxNumber);
	DataResult<CreateCorporateCustomerResponse> add(CreateCorporateCustomerRequest request);
	DataResult<UpdateCorporateCustomerResponse> update(UpdateCorporateCustomerRequest request);
}
