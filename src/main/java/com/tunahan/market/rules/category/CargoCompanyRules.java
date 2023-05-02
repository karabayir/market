package com.tunahan.market.rules.category;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.tunahan.market.core.exceptions.BusinessException;
import com.tunahan.market.core.messages.category.CargoCompanyMessages;
import com.tunahan.market.repository.category.CargoCompanyRepository;
import com.tunahan.market.rules.BaseRules;

@Service
public class CargoCompanyRules extends BaseRules{

	private final CargoCompanyRepository companyRepository;
	
	public CargoCompanyRules(MessageSource messageSource, CargoCompanyRepository companyRepository) {
		super(messageSource);
		this.companyRepository = companyRepository;
	}

	public void checkIfCargoCompanyExists(long id) {
		if(!companyRepository.existsById(id))
			throw new BusinessException(id+messageSource.getMessage(CargoCompanyMessages.Business.notExists, null, LocaleContextHolder.getLocale()));
	}
	
	public void checkIfCargoCompanyExists(String name) {
		if(!companyRepository.existsByNameIgnoreCase(name))
			throw new BusinessException(name+messageSource.getMessage(CargoCompanyMessages.Business.notExists, null, LocaleContextHolder.getLocale()));
	}
	
	public void checkIfCargoCompanyNameExists(String name) {
		if(companyRepository.existsByNameIgnoreCase(name))
			throw new BusinessException(name+messageSource.getMessage(CargoCompanyMessages.Business.alreadyExists,null,LocaleContextHolder.getLocale()));
	}
}
