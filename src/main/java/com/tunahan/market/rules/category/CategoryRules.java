package com.tunahan.market.rules.category;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.tunahan.market.core.exceptions.BusinessException;
import com.tunahan.market.core.messages.category.CategoryMessages;
import com.tunahan.market.repository.category.CategoryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryRules {

	private final CategoryRepository categoryRepository;
	private final MessageSource messageSource;
	
	public void checkIfCategoryExists(long id) {
		if(!categoryRepository.existsById(id))
			throw new BusinessException(messageSource.getMessage(CategoryMessages.Business.notExists, null, Locale.US));
	}
	
	public void checkIfCategoryExists(String name) {
		if(!categoryRepository.existsByNameIgnoreCase(name))
			throw new BusinessException(CategoryMessages.Business.notExists);
	}
	
	public void checkIfCategoryNameExists(String name) {
		if(categoryRepository.existsByNameIgnoreCase(name))
			throw new BusinessException(CategoryMessages.Business.alreadyExists);
	}
	
}
