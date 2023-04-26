package com.tunahan.market.rules.category;

import org.springframework.stereotype.Service;

import com.tunahan.market.core.exceptions.BusinessException;
import com.tunahan.market.core.messages.category.CategoryMessages;
import com.tunahan.market.repository.category.CategoryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryRules {

	private final CategoryRepository categoryRepository;
	
	public void checkIfCategoryExists(long id) {
		if(!categoryRepository.existsById(id))
			throw new BusinessException(CategoryMessages.notExists);
	}
	
	public void checkIfCategoryExists(String name) {
		if(!categoryRepository.existsByNameIgnoreCase(name))
			throw new BusinessException(CategoryMessages.notExists);
	}
}
