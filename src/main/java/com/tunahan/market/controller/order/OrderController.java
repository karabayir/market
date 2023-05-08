package com.tunahan.market.controller.order;

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

import com.tunahan.market.business.abstracts.order.OrderService;
import com.tunahan.market.core.messages.order.OrderMessages;
import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.core.utilities.result.Result;
import com.tunahan.market.dtos.requests.order.CreateOrderRequest;
import com.tunahan.market.dtos.requests.order.UpdateOrderRequest;
import com.tunahan.market.dtos.responses.order.CreateOrderResponse;
import com.tunahan.market.dtos.responses.order.GetAllOrderResponse;
import com.tunahan.market.dtos.responses.order.GetOrderResponse;
import com.tunahan.market.dtos.responses.order.UpdateOrderResponse;
import com.tunahan.market.entities.order.Order;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = OrderMessages.Controller.requestMapping)
@AllArgsConstructor
public class OrderController {

	private final OrderService orderService;
	
	@GetMapping(path = OrderMessages.Controller.getAll)
	public DataResult<List<GetAllOrderResponse>> getAll(){
		return orderService.getAll();
	}
	
	@GetMapping(path = OrderMessages.Controller.getById)
	public DataResult<GetOrderResponse> getById(@PathVariable long id) {
		return orderService.getById(id);
	}
	
	@PostMapping(path = OrderMessages.Controller.add)
	public DataResult<CreateOrderResponse> add(@Valid @RequestBody CreateOrderRequest request) {
		return orderService.add(request);
	}
	
	@PutMapping(path = OrderMessages.Controller.update)
	public DataResult<UpdateOrderResponse> update(@Valid @RequestBody UpdateOrderRequest request){
		return orderService.update(request);
	}
	
	@DeleteMapping(path = OrderMessages.Controller.deleteById)
	public Result delete(long id) {
		return orderService.delete(id);
	}
	
	@GetMapping(path = OrderMessages.Controller.pageable)
	public DataResult<Page<Order>> getAllPageable(@RequestParam int number, @RequestParam int size){
		return orderService.getAllPageable(number, size);
	}
}
