package com.tunahan.market.rules.product;

import org.springframework.stereotype.Service;

import com.tunahan.market.core.exceptions.BusinessException;
import com.tunahan.market.core.messages.product.ProductMessages;
import com.tunahan.market.repository.product.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductRules {

	private final ProductRepository productRepository;
	
	public void checkIfProductExists(long id) {
		if(!productRepository.existsById(id))
			throw new BusinessException(ProductMessages.notExists);
	}
	
	public void checkIfProductExists(String name) {
		if(!productRepository.existsByNameIgnoreCase(name))
			throw new BusinessException(ProductMessages.notExists);
	}
}
