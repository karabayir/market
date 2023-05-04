package com.tunahan.market.rules.customer;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.tunahan.market.core.exceptions.BusinessException;
import com.tunahan.market.core.messages.customer.CorporateCustomerMessages;
import com.tunahan.market.repository.customer.CorporateCustomerRepository;
import com.tunahan.market.rules.BaseRules;

@Service
public class CorporateCustomerRules extends BaseRules{

	private final CorporateCustomerRepository repository;
	
	public CorporateCustomerRules(MessageSource messageSource, CorporateCustomerRepository repository) {
		super(messageSource);
		this.repository = repository;
	}

	public void checkIfCorporateCustomerExists(long id) {
		if(!repository.existsById(id))
			throw new BusinessException(id+messageSource.getMessage(CorporateCustomerMessages.Business.notExists,null,LocaleContextHolder.getLocale()));
	}
	
	public void checkIfCorporateCustomerExists(String name) {
		if(!repository.existsByNameIgnoreCase(name))
			throw new BusinessException(name+messageSource.getMessage(CorporateCustomerMessages.Business.notExists,null,LocaleContextHolder.getLocale()));
	}
	
	public void checkIfCorporateCustomerTaxNumberExists(String number) {
		if(!repository.existsByTaxNumber(number))
			throw new BusinessException(number+messageSource.getMessage(CorporateCustomerMessages.Business.notExists,null,LocaleContextHolder.getLocale()));
	}
	
	public void checkIfTaxNumberForAdd(String number) {
		if(repository.existsByTaxNumber(number))
			throw new BusinessException(number+messageSource.getMessage(CorporateCustomerMessages.Business.alreadyExistsTaxNumber,null,LocaleContextHolder.getLocale()));
	}
}