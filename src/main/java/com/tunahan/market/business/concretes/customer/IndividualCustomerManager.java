package com.tunahan.market.business.concretes.customer;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tunahan.market.business.abstracts.customer.IndividualCustomerService;
import com.tunahan.market.core.messages.customer.IndividualCustomerMessages;
import com.tunahan.market.core.utilities.mapping.ModelMapperService;
import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.core.utilities.result.Result;
import com.tunahan.market.core.utilities.result.SuccessDataResult;
import com.tunahan.market.core.utilities.result.SuccessResult;
import com.tunahan.market.dtos.requests.customer.individual.CreateIndividualCustomerRequest;
import com.tunahan.market.dtos.requests.customer.individual.UpdateIndividualCustomerRequest;
import com.tunahan.market.dtos.responses.customer.individual.CreateIndividualCustomerResponse;
import com.tunahan.market.dtos.responses.customer.individual.GetAllIndividualCustomerResponse;
import com.tunahan.market.dtos.responses.customer.individual.GetIndividualCustomerResponse;
import com.tunahan.market.dtos.responses.customer.individual.UpdateIndividualCustomerResponse;
import com.tunahan.market.entities.customer.IndividualCustomer;
import com.tunahan.market.repository.customer.IndividualCustomerRepository;
import com.tunahan.market.rules.customer.IndividualCustomerRules;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class IndividualCustomerManager implements IndividualCustomerService{
	
	private final IndividualCustomerRepository repository;
	private final ModelMapperService mapperService;
	private final IndividualCustomerRules rules;

	@Override
	public DataResult<List<GetAllIndividualCustomerResponse>> getAll() {
		List<GetAllIndividualCustomerResponse> result = repository.findAll()
				.stream()
				.map(ic -> mapperService.forResponse().map(ic, GetAllIndividualCustomerResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllIndividualCustomerResponse>>(result,IndividualCustomerMessages.Result.getAllIndividual);
	}

	@Override
	public DataResult<GetIndividualCustomerResponse> getById(long id) {
		rules.checkIfIndividualCustomerExists(id);
		IndividualCustomer customer = repository.findById(id).orElseThrow();
		GetIndividualCustomerResponse result = mapperService.forResponse().map(customer, GetIndividualCustomerResponse.class);
		return new SuccessDataResult<GetIndividualCustomerResponse>(result,IndividualCustomerMessages.Result.getIndividualById);
	}

	@Override
	public DataResult<GetIndividualCustomerResponse> getByTCKN(String TCKN) {
		rules.checkIfIndividualCustomerTCKNExists(TCKN);
		IndividualCustomer customer= repository.findByTCKN(TCKN).orElseThrow();
		GetIndividualCustomerResponse result = mapperService.forResponse().map(customer, GetIndividualCustomerResponse.class);
		return new SuccessDataResult<GetIndividualCustomerResponse>(result,IndividualCustomerMessages.Result.getIndividualByTCKN);
	}

	@Override
	public DataResult<List<GetIndividualCustomerResponse>> getByName(String name) {
		rules.checkIfIndividualCustomerExists(name);
		List<IndividualCustomer> customers= repository.findByFirstNameIgnoreCase(name).orElseThrow();
		List<GetIndividualCustomerResponse> result = customers
				.stream()
				.map(c -> mapperService.forResponse().map(c, GetIndividualCustomerResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetIndividualCustomerResponse>>(result,IndividualCustomerMessages.Result.getIndividualByName);
	}

	@Override
	public DataResult<CreateIndividualCustomerResponse> add(CreateIndividualCustomerRequest request) {
		rules.checkIfIndividualCustomerTCKNForAdd(request.getTCKN());
		IndividualCustomer customer = mapperService.forRequest().map(request, IndividualCustomer.class);
		repository.save(customer);
		CreateIndividualCustomerResponse result = mapperService.forResponse().map(customer, CreateIndividualCustomerResponse.class);
		return new SuccessDataResult<CreateIndividualCustomerResponse>(result,IndividualCustomerMessages.Result.addIndividual);
	}

	@Override
	public DataResult<UpdateIndividualCustomerResponse> update(UpdateIndividualCustomerRequest request) {
		rules.checkIfIndividualCustomerExists(request.getId());
		IndividualCustomer customer = mapperService.forRequest().map(request, IndividualCustomer.class);
		repository.save(customer);
		UpdateIndividualCustomerResponse result = mapperService.forResponse().map(customer, UpdateIndividualCustomerResponse.class);
		return new SuccessDataResult<UpdateIndividualCustomerResponse>(result,IndividualCustomerMessages.Result.updateIndividual);
	}

	@Override
	public Result delete(long id) {
		rules.checkIfIndividualCustomerExists(id);
		repository.deleteById(id);
		return new SuccessResult(IndividualCustomerMessages.Result.deleteIndividual);
	}

	@Override
	public DataResult<Page<IndividualCustomer>> getAllPageable(int number, int size) {
		Pageable pageable = PageRequest.of(number, size);
		Page<IndividualCustomer> result = repository.findAll(pageable);
		return new SuccessDataResult<Page<IndividualCustomer>>(result,IndividualCustomerMessages.Result.getAllIndividualPageable);
	}

}
