package com.tunahan.market.business.abstracts.customer;

import java.util.List;

import org.springframework.data.domain.Page;

import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.core.utilities.result.Result;
import com.tunahan.market.dtos.requests.customer.individual.CreateIndividualCustomerRequest;
import com.tunahan.market.dtos.requests.customer.individual.UpdateIndividualCustomerRequest;
import com.tunahan.market.dtos.responses.customer.individual.CreateIndividualCustomerResponse;
import com.tunahan.market.dtos.responses.customer.individual.GetAllIndividualCustomerResponse;
import com.tunahan.market.dtos.responses.customer.individual.GetIndividualCustomerResponse;
import com.tunahan.market.dtos.responses.customer.individual.UpdateIndividualCustomerResponse;
import com.tunahan.market.entities.customer.IndividualCustomer;

public interface IndividualCustomerService {
	
	DataResult <List<GetAllIndividualCustomerResponse>> getAll();
	DataResult<GetIndividualCustomerResponse> getById(long id);
	DataResult<GetIndividualCustomerResponse> getByTCKN(String TCKN);
	DataResult <List<GetIndividualCustomerResponse>> getByName(String name);
	DataResult<CreateIndividualCustomerResponse> add(CreateIndividualCustomerRequest request);
	DataResult<UpdateIndividualCustomerResponse> update(UpdateIndividualCustomerRequest request);
	DataResult<Page<IndividualCustomer>> getAllPageable(int number, int size);
	Result delete(long id);
}
