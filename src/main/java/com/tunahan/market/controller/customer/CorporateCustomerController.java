package com.tunahan.market.controller.customer;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tunahan.market.business.abstracts.customer.CorporateCustomerService;
import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.dtos.requests.customer.CreateCorporateCustomerRequest;
import com.tunahan.market.dtos.responses.customer.corporate.CreateCorporateCustomerResponse;
import com.tunahan.market.dtos.responses.customer.corporate.GetAllCorporateCustomerResponse;
import com.tunahan.market.dtos.responses.customer.corporate.GetCorporateCustomerResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/corporateCustomer/")
@AllArgsConstructor
public class CorporateCustomerController {

	private final CorporateCustomerService service;
	
	@GetMapping("getAll")
	DataResult<List<GetAllCorporateCustomerResponse>> getAll(){
		return service.getAll();
	}
	
	@GetMapping("getById/{id}")
	DataResult<GetCorporateCustomerResponse> getById(@PathVariable long id){
		return service.getById(id);
	}
	
	@GetMapping("getByName")
	DataResult<List<GetCorporateCustomerResponse>> getByName(@RequestParam String name){
		return service.getByName(name);
	}
	
	@GetMapping("getByTaxNumber")
	DataResult<GetCorporateCustomerResponse> getByTaxNumber(@RequestParam String taxNumber){
		return service.getByTaxNumber(taxNumber);
	}
	
	@PostMapping("add")
	DataResult<CreateCorporateCustomerResponse> add(@Valid @RequestBody CreateCorporateCustomerRequest request){
		return service.add(request);
	}
	
	
}