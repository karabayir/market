package com.tunahan.market.controller.customer;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tunahan.market.business.abstracts.customer.CorporateCustomerService;
import com.tunahan.market.core.messages.customer.CorporateCustomerMessages;
import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.core.utilities.result.Result;
import com.tunahan.market.dtos.requests.customer.corporate.CreateCorporateCustomerRequest;
import com.tunahan.market.dtos.requests.customer.corporate.UpdateCorporateCustomerRequest;
import com.tunahan.market.dtos.responses.customer.corporate.CreateCorporateCustomerResponse;
import com.tunahan.market.dtos.responses.customer.corporate.GetAllCorporateCustomerResponse;
import com.tunahan.market.dtos.responses.customer.corporate.GetCorporateCustomerResponse;
import com.tunahan.market.dtos.responses.customer.corporate.UpdateCorporateCustomerResponse;
import com.tunahan.market.entities.customer.CorporateCustomer;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = CorporateCustomerMessages.Controller.requestMapping)
@AllArgsConstructor
public class CorporateCustomerController {

	private final CorporateCustomerService service;
	
	@GetMapping(path = CorporateCustomerMessages.Controller.getAll)
	DataResult<List<GetAllCorporateCustomerResponse>> getAll(){
		return service.getAll();
	}
	
	@GetMapping(path = CorporateCustomerMessages.Controller.getById)
	DataResult<GetCorporateCustomerResponse> getById(@PathVariable long id){
		return service.getById(id);
	}
	
	@GetMapping(path = CorporateCustomerMessages.Controller.getByName)
	DataResult<List<GetCorporateCustomerResponse>> getByName(@RequestParam String name){
		return service.getByName(name);
	}
	
	@GetMapping(path = CorporateCustomerMessages.Controller.getByTaxNumber)
	DataResult<GetCorporateCustomerResponse> getByTaxNumber(@RequestParam String taxNumber){
		return service.getByTaxNumber(taxNumber);
	}
	
	@PostMapping(path = CorporateCustomerMessages.Controller.add)
	DataResult<CreateCorporateCustomerResponse> add(@Valid @RequestBody CreateCorporateCustomerRequest request){
		return service.add(request);
	}
	
	@PutMapping(path = CorporateCustomerMessages.Controller.update)
	DataResult<UpdateCorporateCustomerResponse> update(@Valid @RequestBody UpdateCorporateCustomerRequest request){
		return service.update(request);
	}
	
	@DeleteMapping(path = CorporateCustomerMessages.Controller.deleteById)
	public Result delete(@PathVariable long id) {
		return service.delete(id);
	}
	
	@GetMapping(path = CorporateCustomerMessages.Controller.pageable)
	DataResult<Page<CorporateCustomer>> getAllPageable(@RequestParam int number, @RequestParam int size){
		return service.getAllPageable(number, size);
	}
	
}
