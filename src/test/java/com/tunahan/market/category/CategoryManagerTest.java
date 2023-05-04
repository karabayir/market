package com.tunahan.market.category;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.context.MessageSource;

import com.tunahan.market.business.concretes.category.CategoryManager;
import com.tunahan.market.core.utilities.mapping.ModelMapperManager;
import com.tunahan.market.core.utilities.mapping.ModelMapperService;
import com.tunahan.market.repository.category.CategoryRepository;
import com.tunahan.market.rules.category.CategoryRules;

class CategoryManagerTest {

	private CategoryManager categoryManager;
	private CategoryRepository categoryRepository;
	private ModelMapperService mapperService;
	private CategoryRules categoryRules;
	private MessageSource messageSource;
	
	@BeforeEach
	void setUp() {
		categoryRepository=Mockito.mock(CategoryRepository.class);
		mapperService= new ModelMapperManager(new ModelMapper());
		messageSource=Mockito.mock(MessageSource.class);
		categoryRules=new CategoryRules(messageSource, categoryRepository);
		categoryManager=new CategoryManager(categoryRepository, mapperService, categoryRules);	
	}
	
	@AfterEach()
	void tearDown() {
		
	}
	
}	
