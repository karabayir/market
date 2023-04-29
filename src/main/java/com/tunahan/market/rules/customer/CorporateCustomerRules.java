package com.tunahan.market.rules.customer;

import org.springframework.stereotype.Service;

import com.tunahan.market.core.exceptions.BusinessException;
import com.tunahan.market.core.messages.customer.CorporateCustomerMessages;
import com.tunahan.market.repository.customer.CorporateCustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CorporateCustomerRules {

	private final CorporateCustomerRepository repository;
	
	public void checkIfCorporateCustomerExists(long id) {
		if(!repository.existsById(id))
			throw new BusinessException(id+CorporateCustomerMessages.Business.notExists);
	}
	
	public void checkIfCorporateCustomerExists(String name) {
		if(!repository.existsByNameIgnoreCase(name))
			throw new BusinessException(name+CorporateCustomerMessages.Business.notExists);
	}
	
	public void checkIfCorporateCustomerTaxNumberExists(String number) {
		if(!repository.existsByTaxNumber(number))
			throw new BusinessException(number+CorporateCustomerMessages.Business.notExists);
	}
	
	public void checkIfTaxNumberForAdd(String number) {
		if(repository.existsByTaxNumber(number))
			throw new BusinessException(number+CorporateCustomerMessages.Business.alreadyExistsTaxNumber);
	}
}