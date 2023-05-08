package com.tunahan.market.customer;

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

import com.tunahan.market.business.concretes.customer.IndividualCustomerManager;
import com.tunahan.market.core.exceptions.BusinessException;
import com.tunahan.market.core.messages.customer.IndividualCustomerMessages;
import com.tunahan.market.core.utilities.mapping.ModelMapperManager;
import com.tunahan.market.entities.customer.IndividualCustomer;
import com.tunahan.market.repository.customer.IndividualCustomerRepository;
import com.tunahan.market.rules.customer.IndividualCustomerRules;

@ExtendWith(MockitoExtension.class)
public class IndividualCustomerManagerTest {
	
	@Mock
	private IndividualCustomerRules rules;
	
	@Mock
	private IndividualCustomerRepository repository;

	@Mock
	private ResourceBundleMessageSource messageSource;

	@Mock
	private ModelMapperManager mapperService;
	
	@Mock
	private ModelMapper modelMapper;
	
	@InjectMocks
	private IndividualCustomerManager manager;
	
	@BeforeEach
	void setUp() {
		messageSource = new ResourceBundleMessageSource();
	    messageSource.setBasenames("messages/customer/individual/IndividualMessages");
	    messageSource.setDefaultEncoding("UTF-8");
	    
	    modelMapper = new ModelMapper();
	    mapperService = new ModelMapperManager(modelMapper);       
	}
	
	@Test
	void testCheckIfIndividualCustomerIdExists(){
		IndividualCustomer customer = new  IndividualCustomer();
		customer.setId(1);
		
		Mockito.doThrow(new BusinessException(customer.getId()+ messageSource.getMessage(IndividualCustomerMessages.Business.notExists, null,LocaleContextHolder.getLocale())))
	       .when(rules).checkIfIndividualCustomerExists(customer.getId());
		
		Throwable exception = assertThrows(BusinessException.class, ()-> rules.checkIfIndividualCustomerExists(customer.getId()));
		
		 assertEquals(customer.getId()+"Bireysel müşteri bulunamadı.", exception.getMessage());
	}
	
	@Test
	void testCheckIfIndividualCustomerFirstNameExists(){
		IndividualCustomer customer = new  IndividualCustomer();
		customer.setId(1);
		customer.setFirstName("test");
		
		Mockito.doThrow(new BusinessException(customer.getFirstName()+messageSource.getMessage(IndividualCustomerMessages.Business.notExists, null,LocaleContextHolder.getLocale())))
	       .when(rules).checkIfIndividualCustomerExists(customer.getFirstName());
		
		Throwable exception = assertThrows(BusinessException.class, ()-> rules.checkIfIndividualCustomerExists(customer.getFirstName()));
		
		 assertEquals(customer.getFirstName()+"Bireysel müşteri bulunamadı.", exception.getMessage());
	}
	
	@Test
	void testCheckIfIndividualCustomerTCKNExists(){
		IndividualCustomer customer = new  IndividualCustomer();
		customer.setId(1);
		customer.setFirstName("test");
		customer.setTCKN("12345678910");
		
		Mockito.doThrow(new BusinessException(customer.getTCKN()+messageSource.getMessage(IndividualCustomerMessages.Business.notExists, null,LocaleContextHolder.getLocale())))
	       .when(rules).checkIfIndividualCustomerExists(customer.getTCKN());
		
		Throwable exception = assertThrows(BusinessException.class, ()-> rules.checkIfIndividualCustomerExists(customer.getTCKN()));
		
		 assertEquals(customer.getTCKN()+"Bireysel müşteri bulunamadı.", exception.getMessage());
	}
}
