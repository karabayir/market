package com.tunahan.market.controller.order;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tunahan.market.business.abstracts.order.OrderService;
import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.dtos.requests.order.CreateOrderRequest;
import com.tunahan.market.dtos.requests.order.UpdateOrderRequest;
import com.tunahan.market.dtos.responses.order.CreateOrderResponse;
import com.tunahan.market.dtos.responses.order.GetAllOrderResponse;
import com.tunahan.market.dtos.responses.order.GetOrderResponse;
import com.tunahan.market.dtos.responses.order.UpdateOrderResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/orders/")
@AllArgsConstructor
public class OrderController {

	private final OrderService orderService;
	
	@GetMapping("getAll")
	public DataResult<List<GetAllOrderResponse>> getAll(){
		return orderService.getAll();
	}
	
	@GetMapping("getById/{id}")
	public DataResult<GetOrderResponse> getById(@PathVariable long id) {
		return orderService.getById(id);
	}
	
	@PostMapping("add")
	public DataResult<CreateOrderResponse> add(@Valid @RequestBody CreateOrderRequest request) {
		return orderService.add(request);
	}
	
	@PutMapping("update")
	public DataResult<UpdateOrderResponse> update(@Valid @RequestBody UpdateOrderRequest request){
		return orderService.update(request);
	}
}
