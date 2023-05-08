package com.tunahan.market.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;

import com.tunahan.market.core.exceptions.BusinessException;
import com.tunahan.market.core.messages.customer.CustomerMessages;
import com.tunahan.market.core.utilities.mapping.ModelMapperManager;
import com.tunahan.market.entities.customer.Customer;
import com.tunahan.market.repository.customer.CustomerRepository;
import com.tunahan.market.rules.customer.CustomerRules;

@ExtendWith(MockitoExtension.class)
public class CustomerManagerTest {

	@Mock
	private CustomerRules rules;
	
	@Mock
	private CustomerRepository repository;

	@Mock
	private ResourceBundleMessageSource messageSource;

	@Mock
	private ModelMapperManager mapperService;
	
	@Mock
	private ModelMapper modelMapper;
	
	@BeforeEach
	void setUp() {
		messageSource = new ResourceBundleMessageSource();
	    messageSource.setBasenames("messages/customer/customer/CustomerMessages");
	    messageSource.setDefaultEncoding("UTF-8");
	    
	    modelMapper = new ModelMapper();
	    mapperService = new ModelMapperManager(modelMapper);       
	}
	
	@Test
	void testCheckIfCustomerExists() {
		Customer customer = new Customer();
		customer.setId(1);
		
		Mockito.doThrow(new BusinessException(customer.getId()+ messageSource.getMessage(CustomerMessages.Business.notExists, null,LocaleContextHolder.getLocale())))
	       .when(rules).checkIfCustomerExists(customer.getId());
		
		Throwable exception = assertThrows(BusinessException.class, ()-> rules.checkIfCustomerExists(customer.getId()));
		
		 assertEquals(customer.getId()+"Müşteri bulunamadı.", exception.getMessage());
	}
	
}
