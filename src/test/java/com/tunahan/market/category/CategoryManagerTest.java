package com.tunahan.market.category;

import java.util.Locale;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.support.ResourceBundleMessageSource;

import com.tunahan.market.business.concretes.category.CategoryManager;
import com.tunahan.market.core.exceptions.BusinessException;
import com.tunahan.market.core.messages.category.CategoryMessages;
import com.tunahan.market.core.utilities.mapping.ModelMapperService;
import com.tunahan.market.entities.category.Category;
import com.tunahan.market.repository.category.CategoryRepository;
import com.tunahan.market.rules.category.CategoryRules;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class CategoryManagerTest {
	
	@Mock
	private CategoryRules categoryRules;
	
	@Mock
	private ResourceBundleMessageSource messageSource;

	@Mock
	private ModelMapperService mapperService;

	@Mock
	private CategoryRepository categoryRepository;

	@InjectMocks
	private CategoryManager categoryManager;
	
	
	@BeforeEach
	void setUp() {
		
	
		messageSource = new ResourceBundleMessageSource();
	    messageSource.setBasenames("messages/category/CategoryMessages");
	    messageSource.setDefaultEncoding("UTF-8");
	}
	
	
	@Test
	void testCheckIfCategoryNameExists() {
	    // Given
	    Category category = new Category();
	    category.setId(2);
	    category.setName("Kitap");
	    
	    Mockito.doThrow(new BusinessException(category.getName() + messageSource.getMessage(CategoryMessages.Business.notExists, null, Locale.ENGLISH)))
	       .when(categoryRules).checkIfCategoryExists(category.getName());
	    
	    // When
	    Throwable exception = assertThrows(BusinessException.class, ()-> categoryRules.checkIfCategoryExists(category.getName()));

	    // Then
	    assertEquals(category.getName()+"Category not exists.", exception.getMessage());
	}
	
	
	@Test
	void testCheckIfCategoryIdExists() {
	    // Given
	    Category category = new Category();
	    category.setId(2);
	    category.setName("Kitap");
	    
	    Mockito.doThrow(new BusinessException(category.getId() + messageSource.getMessage(CategoryMessages.Business.notExists, null, Locale.ENGLISH)))
	       .when(categoryRules).checkIfCategoryExists(category.getId());
	    
	    // When
	    Throwable exception = assertThrows(BusinessException.class, ()-> categoryRules.checkIfCategoryExists(category.getId()));

	    // Then
	    assertEquals(category.getId()+"Category not exists.", exception.getMessage());
	}
	
	
	
	
	@AfterEach()
	void tearDown() {
		
	}
	
}	
