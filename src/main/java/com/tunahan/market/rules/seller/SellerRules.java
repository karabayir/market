package com.tunahan.market.rules.seller;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.tunahan.market.core.exceptions.BusinessException;
import com.tunahan.market.core.messages.seller.SellerMessages;
import com.tunahan.market.repository.seller.SellerRepository;
import com.tunahan.market.rules.BaseRules;

@Service
public class SellerRules extends BaseRules{

	private final SellerRepository sellerRepository;
	
	public SellerRules(MessageSource messageSource, SellerRepository sellerRepository) {
		super(messageSource);
		this.sellerRepository = sellerRepository;
	}

	public void checkIfSellerExists(long id) {
		if(!sellerRepository.existsById(id))
			throw new BusinessException(id+messageSource.getMessage(SellerMessages.Business.notExists,null, LocaleContextHolder.getLocale()));
	} 
	
	public void checkIfSellerExists(String name) {
		if(!sellerRepository.existsByNameIgnoreCase(name))
			throw new BusinessException(name+messageSource.getMessage(SellerMessages.Business.notExists,null, LocaleContextHolder.getLocale()));
	}
	
	public void checkIfSellerTaxNumberExists(String number) {
		if(!sellerRepository.existsByTaxNumber(number))
			throw new BusinessException(number+messageSource.getMessage(SellerMessages.Business.notExists,null, LocaleContextHolder.getLocale()));
	}
	
	public void checkIfSellerTaxNumberForAdd(String number) {
		if(sellerRepository.existsByTaxNumber(number))
			throw new BusinessException(number+messageSource.getMessage(SellerMessages.Business.alreadyExists,null, LocaleContextHolder.getLocale()));
	}
}
