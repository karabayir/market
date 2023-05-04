package com.tunahan.market.rules.customer;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.tunahan.market.core.exceptions.BusinessException;
import com.tunahan.market.core.messages.customer.CustomerMessages;
import com.tunahan.market.repository.customer.CustomerRepository;
import com.tunahan.market.rules.BaseRules;

@Service
public class CustomerRules extends BaseRules{

    private final CustomerRepository repository;
	
	public CustomerRules(MessageSource messageSource, CustomerRepository repository) {
		super(messageSource);
		this.repository = repository;
	}

	public void checkIfCustomerExists(long id) {
		if(!repository.existsById(id))
			throw new BusinessException(id+messageSource.getMessage(CustomerMessages.Business.notExists,null,LocaleContextHolder.getLocale()));
	}
}
