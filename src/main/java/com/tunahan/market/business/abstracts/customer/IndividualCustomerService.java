package com.tunahan.market.business.abstracts.customer;

import java.util.List;

import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.dtos.requests.customer.CreateIndividualCustomerRequest;
import com.tunahan.market.dtos.responses.customer.individual.CreateIndividualCustomerResponse;
import com.tunahan.market.dtos.responses.customer.individual.GetAllIndividualCustomerResponse;
import com.tunahan.market.dtos.responses.customer.individual.GetIndividualCustomerResponse;

public interface IndividualCustomerService {
	
	DataResult <List<GetAllIndividualCustomerResponse>> getAll();
	DataResult<GetIndividualCustomerResponse> getById(long id);
	DataResult<GetIndividualCustomerResponse> getByTCKN(String TCKN);
	DataResult <List<GetIndividualCustomerResponse>> getByName(String name);
	DataResult<CreateIndividualCustomerResponse> add(CreateIndividualCustomerRequest request);
}
