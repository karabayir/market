package com.tunahan.market.rules.customer;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.tunahan.market.core.exceptions.BusinessException;
import com.tunahan.market.core.messages.customer.IndividualCustomerMessages;
import com.tunahan.market.repository.customer.IndividualCustomerRepository;
import com.tunahan.market.rules.BaseRules;

@Service
public class IndividualCustomerRules extends BaseRules{

	private final IndividualCustomerRepository repository;
	
	public IndividualCustomerRules(MessageSource messageSource, IndividualCustomerRepository repository) {
		super(messageSource);
		this.repository = repository;
	}

	public void checkIfIndividualCustomerExists(long id) {
		if(!repository.existsById(id))
			throw new BusinessException(id+messageSource.getMessage(IndividualCustomerMessages.Business.notExists,null,LocaleContextHolder.getLocale()));
	}
	
	public void checkIfIndividualCustomerExists(String name) {
		if(!repository.existsByFirstName(name))
			throw new BusinessException(name+messageSource.getMessage(IndividualCustomerMessages.Business.notExists,null,LocaleContextHolder.getLocale()));
	}
	
	public void checkIfIndividualCustomerTCKNExists(String TCKN) {
		if(!repository.existsByTCKN(TCKN))
			throw new BusinessException(TCKN+messageSource.getMessage(IndividualCustomerMessages.Business.notExists,null,LocaleContextHolder.getLocale()));
	}
	
	public void checkIfIndividualCustomerTCKNForAdd(String TCKN) {
		if(repository.existsByTCKN(TCKN))
			throw new BusinessException(TCKN+messageSource.getMessage(IndividualCustomerMessages.Business.alreadyExistsTCKN,null,LocaleContextHolder.getLocale()));
	}
}
