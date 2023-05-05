package com.tunahan.market.business.concretes.order;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tunahan.market.business.abstracts.order.OrderService;
import com.tunahan.market.core.utilities.mapping.ModelMapperService;
import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.core.utilities.result.Result;
import com.tunahan.market.core.utilities.result.SuccessDataResult;
import com.tunahan.market.core.utilities.result.SuccessResult;
import com.tunahan.market.dtos.requests.order.CreateOrderRequest;
import com.tunahan.market.dtos.requests.order.UpdateOrderRequest;
import com.tunahan.market.dtos.responses.order.CreateOrderResponse;
import com.tunahan.market.dtos.responses.order.GetAllOrderResponse;
import com.tunahan.market.dtos.responses.order.GetOrderResponse;
import com.tunahan.market.dtos.responses.order.UpdateOrderResponse;
import com.tunahan.market.entities.order.Order;
import com.tunahan.market.repository.order.OrderRepository;
import com.tunahan.market.rules.customer.CustomerRules;
import com.tunahan.market.rules.order.OrderRules;
import com.tunahan.market.rules.product.ProductRules;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderManager implements OrderService{
	
	private final OrderRepository orderRepository;
	private final ModelMapperService mapperService;
	private final OrderRules rules;
	private final ProductRules productRules;
    private final CustomerRules customerRules;	
	
	@Override
	public DataResult<List<GetAllOrderResponse>> getAll() {
		List<GetAllOrderResponse> result= orderRepository.findAll()
				.stream()
				.map(o -> mapperService.forResponse().map(o, GetAllOrderResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllOrderResponse>>(result, "getAll");
	}

	@Override
	public DataResult<GetOrderResponse> getById(long id) {
		rules.checkIfOrderExists(id);
		Order order = orderRepository.findById(id).orElseThrow();
		GetOrderResponse result= mapperService.forResponse().map(order, GetOrderResponse.class);
		return new SuccessDataResult<GetOrderResponse>(result, "getById");
	}

	@Override
	public DataResult<CreateOrderResponse> add(CreateOrderRequest request) {
		productRules.checkIfProductExists(request.getProductId());
		customerRules.checkIfCustomerExists(request.getCustomerId());
		Order order = mapperService.forRequest().map(request, Order.class);
		order.setId(0);
		orderRepository.save(order);
		CreateOrderResponse result= mapperService.forResponse().map(order, CreateOrderResponse.class);
		return new SuccessDataResult<CreateOrderResponse>(result, "add");
	}

	@Override
	public DataResult<UpdateOrderResponse> update(UpdateOrderRequest request) {
		rules.checkIfOrderExists(request.getId());
		productRules.checkIfProductExists(request.getProductId());
		customerRules.checkIfCustomerExists(request.getCustomerId());
		Order order = mapperService.forRequest().map(request, Order.class);
		orderRepository.save(order);
		UpdateOrderResponse result= mapperService.forResponse().map(order, UpdateOrderResponse.class);
		return new SuccessDataResult<UpdateOrderResponse>(result, "update");
	}

	@Override
	public Result delete(long id) {
		rules.checkIfOrderExists(id);
		orderRepository.deleteById(id);
		return new SuccessResult("delete");
	}

	@Override
	public DataResult<Page<Order>> getAllPageable(int number, int size) {
		Pageable pageable = PageRequest.of(number, size);
		Page<Order> result = orderRepository.findAll(pageable);
		return new SuccessDataResult<Page<Order>>(result, "getAllPageable");
	}

}
