package com.tunahan.market.rules.seller;

import org.springframework.stereotype.Service;

import com.tunahan.market.core.exceptions.BusinessException;
import com.tunahan.market.core.messages.seller.SellerMessages;
import com.tunahan.market.repository.seller.SellerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SellerRules {

	private final SellerRepository sellerRepository;
	
	public void checkIfSellerExists(long id) {
		if(!sellerRepository.existsById(id))
			throw new BusinessException(SellerMessages.notExists);
	} 
	
	public void checkIfSellerExists(String name) {
		if(!sellerRepository.existsByNameIgnoreCase(name))
			throw new BusinessException(SellerMessages.notExists);
	}
}
