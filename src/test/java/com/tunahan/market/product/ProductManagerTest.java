package com.tunahan.market.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;

import com.tunahan.market.business.concretes.product.ProductManager;
import com.tunahan.market.core.exceptions.BusinessException;
import com.tunahan.market.core.messages.product.ProductMessages;
import com.tunahan.market.core.utilities.mapping.ModelMapperManager;
import com.tunahan.market.entities.product.Product;
import com.tunahan.market.repository.product.ProductRepository;
import com.tunahan.market.rules.product.ProductRules;

@ExtendWith(MockitoExtension.class)
public class ProductManagerTest {

	@Mock
	private ProductRules rules;
	
	@Mock
	private ProductRepository repository;
	
	@Mock
	private ResourceBundleMessageSource messageSource;

	@Mock
	private ModelMapperManager mapperService;
	
	@Mock
	private ModelMapper modelMapper;
	
	@InjectMocks
	private ProductManager manager;
	
	@BeforeEach
	void setUp() {
		messageSource = new ResourceBundleMessageSource();
	    messageSource.setBasenames("messages/product/ProductMessages");
	    messageSource.setDefaultEncoding("UTF-8");
	    
	    modelMapper = new ModelMapper();
	    mapperService = new ModelMapperManager(modelMapper);       
	}
	
	@Test
	void testCheckIfProductIdExists() {
		Product product = new Product();
		product.setId(1);
		
		Mockito.doThrow(new BusinessException(product.getId()+ messageSource.getMessage(ProductMessages.Business.notExists, null,LocaleContextHolder.getLocale())))
	       .when(rules).checkIfProductExists(product.getId());
		
		Throwable exception = assertThrows(BusinessException.class, ()-> rules.checkIfProductExists(product.getId()));
		
		 assertEquals(product.getId()+"Ürün mevcut değil.", exception.getMessage());
	}
	
	@Test
	void testCheckIfProductNameExists() {
		Product product = new Product();
		product.setId(1);
		product.setName("test");
		
		Mockito.doThrow(new BusinessException(product.getName()+ messageSource.getMessage(ProductMessages.Business.notExists, null,LocaleContextHolder.getLocale())))
	       .when(rules).checkIfProductExists(product.getName());
		
		Throwable exception = assertThrows(BusinessException.class, ()-> rules.checkIfProductExists(product.getName()));
		
		 assertEquals(product.getName()+"Ürün mevcut değil.", exception.getMessage());
	}
}
