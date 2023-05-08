package com.tunahan.market.controller.discount;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tunahan.market.business.abstracts.discount.DiscountService;
import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.core.utilities.result.Result;
import com.tunahan.market.dtos.requests.discount.CreateDiscountRequest;
import com.tunahan.market.dtos.requests.discount.UpdateDiscountRequest;
import com.tunahan.market.dtos.responses.discount.CreateDiscountResponse;
import com.tunahan.market.dtos.responses.discount.GetAllDiscountResponse;
import com.tunahan.market.dtos.responses.discount.GetDiscountResponse;
import com.tunahan.market.dtos.responses.discount.UpdateDiscountResponse;
import com.tunahan.market.entities.preOrder.Discount;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/discounts/")
@AllArgsConstructor
public class DiscountController {

	private final DiscountService discountService;
	
	@GetMapping("getAll")
	DataResult<List<GetAllDiscountResponse>> getAll(){
		return discountService.getAll();
	}
	
	@GetMapping("getById/{id}")
	DataResult<GetDiscountResponse> getById(@PathVariable long id){
		return discountService.getById(id);
	}
	
	@GetMapping("getByName")
	DataResult<GetDiscountResponse> getByName(@RequestParam String name){
		return discountService.getByName(name);
	}
	
	@PostMapping("add")
	DataResult<CreateDiscountResponse> add(@Valid @RequestBody CreateDiscountRequest request){
		return discountService.add(request);
	}
	
	@PutMapping("update")
	DataResult<UpdateDiscountResponse> update(@Valid @RequestBody UpdateDiscountRequest request){
		return discountService.update(request);
	}
	
	@GetMapping("getAllPagination")
	DataResult<Page<Discount>> getAllPageable(@RequestParam int number, @RequestParam int size){
		return discountService.getAllPageable(number, size);
	}
	
	Result delete(@PathVariable long id) {
		return discountService.delete(id);
	}
}
