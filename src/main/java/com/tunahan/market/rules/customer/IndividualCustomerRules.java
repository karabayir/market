package com.tunahan.market.rules.customer;

import org.springframework.stereotype.Service;

import com.tunahan.market.core.exceptions.BusinessException;
import com.tunahan.market.core.messages.customer.IndividualCustomerMessages;
import com.tunahan.market.repository.customer.IndividualCustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class IndividualCustomerRules {

	private final IndividualCustomerRepository repository;
	
	public void checkIfIndividualCustomerExists(long id) {
		if(!repository.existsById(id))
			throw new BusinessException(id+IndividualCustomerMessages.Business.notExists);
	}
	
	public void checkIfIndividualCustomerExists(String name) {
		if(!repository.existsByFirstName(name))
			throw new BusinessException(name+IndividualCustomerMessages.Business.notExists);
	}
	
	public void checkIfIndividualCustomerTCKNExists(String TCKN) {
		if(!repository.existsByTCKN(TCKN))
			throw new BusinessException(TCKN+IndividualCustomerMessages.Business.notExists);
	}
	
	public void checkIfIndividualCustomerTCKNForAdd(String TCKN) {
		if(repository.existsByTCKN(TCKN))
			throw new BusinessException(TCKN+IndividualCustomerMessages.Business.alreadyExistsTCKN);
	}
}
