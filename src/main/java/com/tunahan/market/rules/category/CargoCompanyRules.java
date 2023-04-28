package com.tunahan.market.rules.category;

import org.springframework.stereotype.Service;

import com.tunahan.market.core.exceptions.BusinessException;
import com.tunahan.market.core.messages.category.CargoCompanyMessages;
import com.tunahan.market.repository.category.CargoCompanyRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CargoCompanyRules {

	private final CargoCompanyRepository companyRepository;
	
	public void checkIfCargoCompanyExists(long id) {
		if(!companyRepository.existsById(id))
			throw new BusinessException(CargoCompanyMessages.Business.notExists);
	}
	
	public void checkIfCargoCompanyExists(String name) {
		if(!companyRepository.existsByNameIgnoreCase(name))
			throw new BusinessException(CargoCompanyMessages.Business.notExists);
	}
}
