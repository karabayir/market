package com.tunahan.market.business.concretes.order;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tunahan.market.business.abstracts.order.OrderService;
import com.tunahan.market.core.utilities.mapping.ModelMapperService;
import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.core.utilities.result.SuccessDataResult;
import com.tunahan.market.dtos.requests.order.CreateOrderRequest;
import com.tunahan.market.dtos.responses.order.CreateOrderResponse;
import com.tunahan.market.dtos.responses.order.GetAllOrderResponse;
import com.tunahan.market.dtos.responses.order.GetOrderResponse;
import com.tunahan.market.entities.order.Order;
import com.tunahan.market.repository.order.OrderRepository;
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
    //private final CustomerRules customerRules;	
	
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
	public DataResult<CreateOrderResponse> add(CreateOrderRequest createRequest) {
		productRules.checkIfProductExists(createRequest.getProductId());
		//customerRules.checkIfCustomerExists(createRequest.getCustomerId());
		Order order = mapperService.forRequest().map(createRequest, Order.class);
		order.setId(0);
		orderRepository.save(order);
		CreateOrderResponse result= mapperService.forResponse().map(order, CreateOrderResponse.class);
		return new SuccessDataResult<CreateOrderResponse>(result, "add");
	}

}
