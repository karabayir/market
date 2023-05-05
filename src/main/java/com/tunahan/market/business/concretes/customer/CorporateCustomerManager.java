package com.tunahan.market.business.concretes.customer;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tunahan.market.business.abstracts.customer.CorporateCustomerService;
import com.tunahan.market.core.utilities.mapping.ModelMapperService;
import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.core.utilities.result.Result;
import com.tunahan.market.core.utilities.result.SuccessDataResult;
import com.tunahan.market.core.utilities.result.SuccessResult;
import com.tunahan.market.dtos.requests.customer.corporate.CreateCorporateCustomerRequest;
import com.tunahan.market.dtos.requests.customer.corporate.UpdateCorporateCustomerRequest;
import com.tunahan.market.dtos.responses.customer.corporate.CreateCorporateCustomerResponse;
import com.tunahan.market.dtos.responses.customer.corporate.GetAllCorporateCustomerResponse;
import com.tunahan.market.dtos.responses.customer.corporate.GetCorporateCustomerResponse;
import com.tunahan.market.dtos.responses.customer.corporate.UpdateCorporateCustomerResponse;
import com.tunahan.market.entities.customer.CorporateCustomer;
import com.tunahan.market.repository.customer.CorporateCustomerRepository;
import com.tunahan.market.rules.customer.CorporateCustomerRules;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CorporateCustomerManager implements CorporateCustomerService{

	private final CorporateCustomerRepository repository;
	private final ModelMapperService mapperService;
	private final CorporateCustomerRules rules;
	
	
	@Override
	public DataResult<List<GetAllCorporateCustomerResponse>> getAll() {
		List<GetAllCorporateCustomerResponse> result = repository.findAll()
				.stream()
				.map(cc -> mapperService.forResponse().map(cc, GetAllCorporateCustomerResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllCorporateCustomerResponse>>(result, "getAll");
	}
	@Override
	public DataResult<GetCorporateCustomerResponse> getById(long id) {
		rules.checkIfCorporateCustomerExists(id);
		CorporateCustomer customer = repository.findById(id).orElseThrow();
		GetCorporateCustomerResponse result= mapperService.forResponse().map(customer, GetCorporateCustomerResponse.class);
		return new SuccessDataResult<GetCorporateCustomerResponse>(result, "getById");
	}
	@Override
	public DataResult<List<GetCorporateCustomerResponse>> getByName(String name) {
		rules.checkIfCorporateCustomerExists(name);
		List<CorporateCustomer> customers = repository.findByNameIgnoreCase(name).orElseThrow();
		List<GetCorporateCustomerResponse> result = customers
				.stream()
				.map(cc-> mapperService.forResponse().map(cc, GetCorporateCustomerResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetCorporateCustomerResponse>>(result, "getByName");
	}
	@Override
	public DataResult<GetCorporateCustomerResponse> getByTaxNumber(String taxNumber) {
		rules.checkIfCorporateCustomerTaxNumberExists(taxNumber);
		CorporateCustomer customer= repository.findByTaxNumber(taxNumber).orElseThrow();
		GetCorporateCustomerResponse result = mapperService.forResponse().map(customer, GetCorporateCustomerResponse.class);
		return new SuccessDataResult<GetCorporateCustomerResponse>(result, "getByTaxNumber");
	}
	@Override
	public DataResult<CreateCorporateCustomerResponse> add(CreateCorporateCustomerRequest request) {
		rules.checkIfTaxNumberForAdd(request.getTaxNumber());
		CorporateCustomer customer = mapperService.forRequest().map(request, CorporateCustomer.class);
		repository.save(customer);
		CreateCorporateCustomerResponse result = mapperService.forResponse().map(customer, CreateCorporateCustomerResponse.class);
		return new SuccessDataResult<CreateCorporateCustomerResponse>(result, "add");
	}
	@Override
	public DataResult<UpdateCorporateCustomerResponse> update(UpdateCorporateCustomerRequest request) {
		rules.checkIfCorporateCustomerExists(request.getId());
		CorporateCustomer customer = mapperService.forRequest().map(request, CorporateCustomer.class);
		repository.save(customer);
		UpdateCorporateCustomerResponse result = mapperService.forResponse().map(customer, UpdateCorporateCustomerResponse.class);
		return new SuccessDataResult<UpdateCorporateCustomerResponse>(result, "update");
	}
	@Override
	public Result delete(long id) {
		rules.checkIfCorporateCustomerExists(id);
		repository.deleteById(id);
		return new SuccessResult("delete");
	}
	@Override
	public DataResult<Page<CorporateCustomer>> getAllPageable(int number, int size) {
		Pageable pageable = PageRequest.of(number, size);
		Page<CorporateCustomer> result = repository.findAll(pageable);
		return new SuccessDataResult<Page<CorporateCustomer>>(result, "getAllPageable");
	}
}
