package com.tunahan.market.order;

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

import com.tunahan.market.business.concretes.order.OrderManager;
import com.tunahan.market.core.exceptions.BusinessException;
import com.tunahan.market.core.messages.order.OrderMessages;
import com.tunahan.market.core.utilities.mapping.ModelMapperManager;
import com.tunahan.market.entities.order.Order;
import com.tunahan.market.repository.order.OrderRepository;
import com.tunahan.market.rules.order.OrderRules;

@ExtendWith(MockitoExtension.class)
public class OrderManagerTest {

	@Mock
	private OrderRules rules;
	
	@Mock
	private OrderRepository repository;
	
	@Mock
	private ResourceBundleMessageSource messageSource;

	@Mock
	private ModelMapperManager mapperService;
	
	@Mock
	private ModelMapper modelMapper;
	
	@InjectMocks
	private OrderManager manager;
	
	@BeforeEach
	void setUp() {
		messageSource = new ResourceBundleMessageSource();
	    messageSource.setBasenames("messages/order/OrderMessages");
	    messageSource.setDefaultEncoding("UTF-8");
	    
	    modelMapper = new ModelMapper();
	    mapperService = new ModelMapperManager(modelMapper);       
	}
	
	@Test
	void testCheckIfOrderExists() {
		Order order = new Order();
		order.setId(1);
		
		Mockito.doThrow(new BusinessException(order.getId()+ messageSource.getMessage(OrderMessages.Business.notExists, null,LocaleContextHolder.getLocale())))
	       .when(rules).checkIfOrderExists(order.getId());
		
		Throwable exception = assertThrows(BusinessException.class, ()-> rules.checkIfOrderExists(order.getId()));
		
		 assertEquals(order.getId()+"Sipariş mevcut değil.", exception.getMessage());
	}
	

}
