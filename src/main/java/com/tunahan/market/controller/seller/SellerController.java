package com.tunahan.market.controller.seller;

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

import com.tunahan.market.business.abstracts.seller.SellerService;
import com.tunahan.market.core.messages.seller.SellerMessages;
import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.core.utilities.result.Result;
import com.tunahan.market.dtos.requests.seller.CreateSellerRequest;
import com.tunahan.market.dtos.requests.seller.UpdateSellerRequest;
import com.tunahan.market.dtos.responses.seller.CreateSellerResponse;
import com.tunahan.market.dtos.responses.seller.GetAllSellerResponse;
import com.tunahan.market.dtos.responses.seller.GetSellerResponse;
import com.tunahan.market.dtos.responses.seller.UpdateSellerResponse;
import com.tunahan.market.entities.seller.Seller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = SellerMessages.Controller.requestMapping)
@AllArgsConstructor
public class SellerController {

	private final SellerService sellerService;
	
	@GetMapping(path = SellerMessages.Controller.getAll)
	public DataResult<List<GetAllSellerResponse>> getAll(){
		return sellerService.getAll();
	}
	
	@GetMapping(path = SellerMessages.Controller.getById)
	public DataResult<GetSellerResponse> getById(@PathVariable long id) {
		return sellerService.getById(id);
	}
	
	@GetMapping(path = SellerMessages.Controller.getByName)
	public DataResult<List<GetSellerResponse>> getByName(@RequestParam String name){
		return sellerService.getByName(name);
	}
	
	@GetMapping(path = SellerMessages.Controller.getByTaxNumber)
	public DataResult<GetSellerResponse> getByTaxNumber(@RequestParam String number){
		return sellerService.getByTaxNumber(number);
	}
	
	@PostMapping(path = SellerMessages.Controller.add)
	public DataResult<CreateSellerResponse> add(@Valid @RequestBody CreateSellerRequest request) {
		return sellerService.add(request);
	}
	
	@PutMapping(path = SellerMessages.Controller.update)
	DataResult<UpdateSellerResponse> update(@Valid @RequestBody UpdateSellerRequest request){
		return sellerService.update(request);
	}
	
	@DeleteMapping(path = SellerMessages.Controller.deleteById)
	public Result delete(@PathVariable long id) {
		return sellerService.delete(id);
	}
	
	@GetMapping(path = SellerMessages.Controller.pageable)
	public DataResult<Page<Seller>> getAllPageable(@RequestParam int number, @RequestParam int size){
		return sellerService.getAllPageable(number, size);
	}
}
