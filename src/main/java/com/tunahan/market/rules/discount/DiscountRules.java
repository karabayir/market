package com.tunahan.market.rules.discount;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.tunahan.market.core.exceptions.BusinessException;
import com.tunahan.market.core.messages.discount.DiscountMessages;
import com.tunahan.market.repository.preOrder.DiscountRepository;
import com.tunahan.market.rules.BaseRules;

@Service
public class DiscountRules extends BaseRules{

	private final DiscountRepository repository;

	public DiscountRules(MessageSource messageSource, DiscountRepository repository) {
		super(messageSource);
		this.repository = repository;
	}
	
	public void checkIfDiscountExists(long id) {
		if(!repository.existsById(id))
			throw new BusinessException(id+messageSource.getMessage(DiscountMessages.Business.notExists, null, LocaleContextHolder.getLocale()));
	}
	
	public void checkIfDiscountExists(String name) {
		if(!repository.existsByNameIgnoreCase(name))
			throw new BusinessException(name+messageSource.getMessage(DiscountMessages.Business.notExists, null, LocaleContextHolder.getLocale()));
	}
}
