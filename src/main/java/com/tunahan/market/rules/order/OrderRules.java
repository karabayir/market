package com.tunahan.market.rules.order;

import org.springframework.stereotype.Service;

import com.tunahan.market.core.exceptions.BusinessException;
import com.tunahan.market.core.messages.order.OrderMessages;
import com.tunahan.market.repository.order.OrderRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderRules {

	private final OrderRepository orderRepository;
	
	public void checkIfOrderExists(long id) {
		if(!orderRepository.existsById(id))
			throw new BusinessException(OrderMessages.notExists);
	}

}
