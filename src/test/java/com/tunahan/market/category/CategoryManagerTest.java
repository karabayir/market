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
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.support.ResourceBundleMessageSource;

import com.tunahan.market.business.concretes.category.CategoryManager;
import com.tunahan.market.core.exceptions.BusinessException;
import com.tunahan.market.core.messages.category.CategoryMessages;
import com.tunahan.market.core.utilities.mapping.ModelMapperManager;
import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.dtos.requests.category.CreateCategoryRequest;
import com.tunahan.market.dtos.responses.category.CreateCategoryResponse;
import com.tunahan.market.entities.category.Category;
import com.tunahan.market.repository.category.CategoryRepository;
import com.tunahan.market.rules.category.CategoryRules;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryManagerTest {
	
	@Mock
	private CategoryRules categoryRules;
	
	@Mock
	private ResourceBundleMessageSource messageSource;

	@Mock
	private ModelMapperManager mapperService;
	
	@Mock
	private ModelMapper modelMapper;

	@Mock
	private CategoryRepository categoryRepository;

	@InjectMocks
	private CategoryManager categoryManager;
	
	@BeforeEach
	void setUp() {
	
	
		messageSource = new ResourceBundleMessageSource();
	    messageSource.setBasenames("messages/category/CategoryMessages");
	    messageSource.setDefaultEncoding("UTF-8");
	    
	    modelMapper = new ModelMapper();
	    mapperService = new ModelMapperManager(modelMapper);   
	    
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
	
	@Test
	void testCheckIfCategoryNameForAdd() {
	    // Given
	    Category category = new Category();
	    category.setId(2);
	    category.setName("Kitap");
	    
	    Mockito.doThrow(new BusinessException(category.getId() + messageSource.getMessage(CategoryMessages.Business.alreadyExists, null, Locale.ENGLISH)))
	       .when(categoryRules).checkIfCategoryNameExists(category.getName());
	    
	    // When
	    Throwable exception = assertThrows(BusinessException.class, ()-> categoryRules.checkIfCategoryNameExists(category.getName()));

	    // Then
	    assertEquals(category.getId()+"Category already exists.", exception.getMessage());
	}
	
	@AfterEach()
	void tearDown() {
		
	}
	
}	
