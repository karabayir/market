package com.tunahan.market.rules.product;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.tunahan.market.core.exceptions.BusinessException;
import com.tunahan.market.core.messages.product.ProductMessages;
import com.tunahan.market.repository.product.ProductRepository;
import com.tunahan.market.rules.BaseRules;

@Service
public class ProductRules extends BaseRules{

	private final ProductRepository productRepository;
	
	public ProductRules(MessageSource messageSource, ProductRepository productRepository) {
		super(messageSource);
		this.productRepository = productRepository;
	}

	public void checkIfProductExists(long id) {
		if(!productRepository.existsById(id))
			throw new BusinessException(id+messageSource.getMessage(ProductMessages.Business.notExists, null, LocaleContextHolder.getLocale()));
	}
	
	public void checkIfProductExists(String name) {
		if(!productRepository.existsByNameIgnoreCase(name))
			throw new BusinessException(name+messageSource.getMessage(ProductMessages.Business.notExists, null, LocaleContextHolder.getLocale()));
	}
}
