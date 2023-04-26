package com.tunahan.market.business.concretes.order;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tunahan.market.business.abstracts.order.OrderService;
import com.tunahan.market.core.utilities.mapping.ModelMapperService;
import com.tunahan.market.dtos.requests.order.CreateOrderRequest;
import com.tunahan.market.dtos.responses.order.CreateOrderResponse;
import com.tunahan.market.dtos.responses.order.GetAllOrderResponse;
import com.tunahan.market.dtos.responses.order.GetOrderResponse;
import com.tunahan.market.entities.order.Order;
import com.tunahan.market.repository.order.OrderRepository;
import com.tunahan.market.rules.order.OrderRules;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderManager implements OrderService{
	
	private final OrderRepository orderRepository;
	private final ModelMapperService mapperService;
	private final OrderRules rules;
	
	@Override
	public List<GetAllOrderResponse> getAll() {
		return orderRepository.findAll()
				.stream()
				.map(o -> mapperService.forResponse().map(o, GetAllOrderResponse.class))
				.collect(Collectors.toList());
	}

	@Override
	public GetOrderResponse getById(long id) {
		rules.checkIfOrderExists(id);
		Order order = orderRepository.findById(id).orElseThrow();
		return mapperService.forResponse().map(order, GetOrderResponse.class);
	}

	@Override
	public CreateOrderResponse add(CreateOrderRequest createRequest) {
		Order order = mapperService.forRequest().map(createRequest, Order.class);
		order.setId(0);
		orderRepository.save(order);
		return mapperService.forResponse().map(order, CreateOrderResponse.class);
	}

}
