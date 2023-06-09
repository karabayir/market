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

import com.tunahan.market.business.abstracts.customer.IndividualCustomerService;
import com.tunahan.market.core.messages.customer.IndividualCustomerMessages;
import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.core.utilities.result.Result;
import com.tunahan.market.dtos.requests.customer.individual.CreateIndividualCustomerRequest;
import com.tunahan.market.dtos.requests.customer.individual.UpdateIndividualCustomerRequest;
import com.tunahan.market.dtos.responses.customer.individual.CreateIndividualCustomerResponse;
import com.tunahan.market.dtos.responses.customer.individual.GetAllIndividualCustomerResponse;
import com.tunahan.market.dtos.responses.customer.individual.GetIndividualCustomerResponse;
import com.tunahan.market.dtos.responses.customer.individual.UpdateIndividualCustomerResponse;
import com.tunahan.market.entities.customer.IndividualCustomer;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = IndividualCustomerMessages.Controller.requestMapping)
@AllArgsConstructor
public class IndividualCustomerController {

	private final IndividualCustomerService service;
	
	@GetMapping(path = IndividualCustomerMessages.Controller.getAll)
	DataResult <List<GetAllIndividualCustomerResponse>> getAll(){
		return service.getAll();
	}
	
	@GetMapping(path = IndividualCustomerMessages.Controller.getById)
	DataResult<GetIndividualCustomerResponse> getById(@PathVariable long id){
		return service.getById(id);
	}
	
	@GetMapping(path = IndividualCustomerMessages.Controller.getByTCKN)
	DataResult<GetIndividualCustomerResponse> getByTCKN(@RequestParam String TCKN){
		return service.getByTCKN(TCKN);
	}
	
	@GetMapping(path = IndividualCustomerMessages.Controller.getByName)
	DataResult <List<GetIndividualCustomerResponse>> getByName(@RequestParam String name){
		return service.getByName(name);
	}
	
	@PostMapping(path = IndividualCustomerMessages.Controller.add)
	DataResult<CreateIndividualCustomerResponse> add(@Valid @RequestBody CreateIndividualCustomerRequest request){
		return service.add(request);
	}
	
	@PutMapping(path = IndividualCustomerMessages.Controller.update)
	public DataResult<UpdateIndividualCustomerResponse> update(@Valid @RequestBody UpdateIndividualCustomerRequest request){
		return service.update(request);
	}
	
	@DeleteMapping(path = IndividualCustomerMessages.Controller.deleteById)
	public Result delete(@PathVariable long id) {
		return service.delete(id);
	}
	
	@GetMapping(path = IndividualCustomerMessages.Controller.pageable)
	public DataResult<Page<IndividualCustomer>> getAllPageable(@RequestParam int number, @RequestParam int size){
		return service.getAllPageable(number, size);
	}
}

