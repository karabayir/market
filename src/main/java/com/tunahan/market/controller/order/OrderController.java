package com.tunahan.market.controller.order;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tunahan.market.business.abstracts.order.OrderService;
import com.tunahan.market.dtos.requests.order.CreateOrderRequest;
import com.tunahan.market.dtos.responses.order.CreateOrderResponse;
import com.tunahan.market.dtos.responses.order.GetAllOrderResponse;
import com.tunahan.market.dtos.responses.order.GetOrderResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/orders/")
@AllArgsConstructor
public class OrderController {

	private final OrderService orderService;
	
	@GetMapping("getAll")
	public List<GetAllOrderResponse> getAll(){
		return orderService.getAll();
	}
	
	@GetMapping("getById/{id}")
	GetOrderResponse getById(@PathVariable long id) {
		return orderService.getById(id);
	}
	
	@PostMapping("add")
	CreateOrderResponse add(@RequestBody CreateOrderRequest createRequest) {
		return orderService.add(createRequest);
	}
}
