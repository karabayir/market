package com.tunahan.market.rules.customer;

import org.springframework.stereotype.Service;

import com.tunahan.market.core.exceptions.BusinessException;
import com.tunahan.market.core.messages.customer.CustomerMessages;
import com.tunahan.market.repository.customer.CustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerRules {

	private final CustomerRepository repository;
	
	public void checkIfCustomerExists(long id) {
		if(!repository.existsById(id))
			throw new BusinessException(CustomerMessages.Business.notExists);
	}
}
