package com.tunahan.market.controller.seller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tunahan.market.business.abstracts.seller.SellerService;
import com.tunahan.market.dtos.requests.seller.CreateSellerRequest;
import com.tunahan.market.dtos.responses.seller.CreateSellerResponse;
import com.tunahan.market.dtos.responses.seller.GetAllSellerResponse;
import com.tunahan.market.dtos.responses.seller.GetSellerResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/sellers/")
@AllArgsConstructor
public class SellerController {

	private final SellerService sellerService;
	
	@GetMapping("getAll")
	public List<GetAllSellerResponse> getAll(){
		return sellerService.getAll();
	}
	
	@GetMapping("getById/{id}")
	public GetSellerResponse getById(@PathVariable long id) {
		return sellerService.getById(id);
	}
	
	@GetMapping("getByName")
	public List<GetSellerResponse> getByName(@RequestParam String name){
		return sellerService.getByName(name);
	}
	
	@PostMapping("add")
	public CreateSellerResponse add(@Valid @RequestBody CreateSellerRequest createRequest) {
		return sellerService.add(createRequest);
	}
}
