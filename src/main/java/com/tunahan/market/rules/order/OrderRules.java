package com.tunahan.market.rules.order;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.tunahan.market.core.exceptions.BusinessException;
import com.tunahan.market.core.messages.order.OrderMessages;
import com.tunahan.market.repository.order.OrderRepository;
import com.tunahan.market.rules.BaseRules;

@Service
public class OrderRules extends BaseRules{

	private final OrderRepository orderRepository;
	
	public OrderRules(MessageSource messageSource, OrderRepository orderRepository) {
		super(messageSource);
		this.orderRepository = orderRepository;
	}
	
	public void checkIfOrderExists(long id) {
		if(!orderRepository.existsById(id))
			throw new BusinessException(id+messageSource.getMessage(OrderMessages.Business.notExists, null, LocaleContextHolder.getLocale()));
	}

}
