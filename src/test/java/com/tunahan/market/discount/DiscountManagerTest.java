package com.tunahan.market.discount;

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

import com.tunahan.market.business.concretes.discount.DiscountManager;
import com.tunahan.market.core.exceptions.BusinessException;
import com.tunahan.market.core.messages.discount.DiscountMessages;
import com.tunahan.market.core.utilities.mapping.ModelMapperManager;
import com.tunahan.market.entities.preOrder.Discount;
import com.tunahan.market.repository.preOrder.DiscountRepository;
import com.tunahan.market.rules.discount.DiscountRules;

@ExtendWith(MockitoExtension.class)
public class DiscountManagerTest {
	
	@Mock
	private DiscountRules rules;
	
	@Mock
	private DiscountRepository repository;

	@Mock
	private ResourceBundleMessageSource messageSource;

	@Mock
	private ModelMapperManager mapperService;
	
	@Mock
	private ModelMapper modelMapper;
	
	@InjectMocks
	private DiscountManager manager;
	
	@BeforeEach
	void setUp() {
		messageSource = new ResourceBundleMessageSource();
	    messageSource.setBasenames("messages/discount/DiscountMessages");
	    messageSource.setDefaultEncoding("UTF-8");
	    
	    modelMapper = new ModelMapper();
	    mapperService = new ModelMapperManager(modelMapper);       
	}
	
	@Test
	void testCheckIfDiscountIdExists() {
		Discount discount = new Discount();
		discount.setId(1);
		
		Mockito.doThrow(new BusinessException(discount.getId()+ messageSource.getMessage(DiscountMessages.Business.notExists, null,LocaleContextHolder.getLocale())))
	       .when(rules).checkIfDiscountExists(discount.getId());
		
		Throwable exception = assertThrows(BusinessException.class, ()-> rules.checkIfDiscountExists(discount.getId()));
		
		 assertEquals(discount.getId()+"İndirim bulunamadı.", exception.getMessage());
	}
	
	@Test
	void testCheckIfDiscountNameExists() {
		Discount discount = new Discount();
		discount.setId(1);
		discount.setName("test");
		
		Mockito.doThrow(new BusinessException(discount.getName()+ messageSource.getMessage(DiscountMessages.Business.notExists, null,LocaleContextHolder.getLocale())))
	       .when(rules).checkIfDiscountExists(discount.getName());
		
		Throwable exception = assertThrows(BusinessException.class, ()-> rules.checkIfDiscountExists(discount.getName()));
		
		 assertEquals(discount.getName()+"İndirim bulunamadı.", exception.getMessage());
	}
}
