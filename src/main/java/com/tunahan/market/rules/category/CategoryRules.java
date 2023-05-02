package com.tunahan.market.rules.category;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.tunahan.market.core.exceptions.BusinessException;
import com.tunahan.market.core.messages.category.CategoryMessages;
import com.tunahan.market.repository.category.CategoryRepository;
import com.tunahan.market.rules.BaseRules;

@Service
public class CategoryRules extends BaseRules{

	private final CategoryRepository categoryRepository;

	public CategoryRules(MessageSource messageSource, CategoryRepository categoryRepository) {
		super(messageSource);
		this.categoryRepository = categoryRepository;
	}

	public void checkIfCategoryExists(long id) {
		if(!categoryRepository.existsById(id))
			throw new BusinessException(id+messageSource.getMessage(CategoryMessages.Business.notExists, null, Locale.FRENCH));
	}
	
	public void checkIfCategoryExists(String name) {
		if(!categoryRepository.existsByNameIgnoreCase(name))
			throw new BusinessException(name+messageSource.getMessage(CategoryMessages.Business.notExists,null, Locale.ENGLISH));
	}
	
	public void checkIfCategoryNameExists(String name) {
		if(categoryRepository.existsByNameIgnoreCase(name))
			throw new BusinessException(name+messageSource.getMessage(CategoryMessages.Business.alreadyExists, null, LocaleContextHolder.getLocale()));
	}
	
}
