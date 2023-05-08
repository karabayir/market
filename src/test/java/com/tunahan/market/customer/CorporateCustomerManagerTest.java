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

import com.tunahan.market.business.concretes.customer.CorporateCustomerManager;
import com.tunahan.market.core.exceptions.BusinessException;
import com.tunahan.market.core.messages.customer.IndividualCustomerMessages;
import com.tunahan.market.core.utilities.mapping.ModelMapperManager;
import com.tunahan.market.entities.customer.CorporateCustomer;
import com.tunahan.market.repository.customer.CorporateCustomerRepository;
import com.tunahan.market.rules.customer.CorporateCustomerRules;

@ExtendWith(MockitoExtension.class)
public class CorporateCustomerManagerTest {

	@Mock
	private CorporateCustomerRules rules;
	
	@Mock
	private CorporateCustomerRepository repository;

	@Mock
	private ResourceBundleMessageSource messageSource;

	@Mock
	private ModelMapperManager mapperService;
	
	@Mock
	private ModelMapper modelMapper;
	
	@InjectMocks
	private CorporateCustomerManager manager;
	
	@BeforeEach
	void setUp() {
		messageSource = new ResourceBundleMessageSource();
	    messageSource.setBasenames("messages/customer/corporate/CorporateMessages");
	    messageSource.setDefaultEncoding("UTF-8");
	    
	    modelMapper = new ModelMapper();
	    mapperService = new ModelMapperManager(modelMapper);       
	}
	
	@Test
	void testCheckIfCorporateCustomerIdExists() {
		CorporateCustomer customer = new CorporateCustomer();
		customer.setId(1);
		
		Mockito.doThrow(new BusinessException(customer.getId()+messageSource.getMessage(IndividualCustomerMessages.Business.notExists, null,LocaleContextHolder.getLocale())))
	       .when(rules).checkIfCorporateCustomerExists(customer.getId());
		
		Throwable exception = assertThrows(BusinessException.class, ()-> rules.checkIfCorporateCustomerExists(customer.getId()));
		
		 assertEquals(customer.getId()+"Kurumsal müşteri bulunamadı.", exception.getMessage());
	}
	
	@Test
	void testCheckIfCorporateCustomerNameExists() {
		CorporateCustomer customer = new CorporateCustomer();
		customer.setId(1);
		customer.setName("test");
		
		Mockito.doThrow(new BusinessException(customer.getName()+messageSource.getMessage(IndividualCustomerMessages.Business.notExists, null,LocaleContextHolder.getLocale())))
	       .when(rules).checkIfCorporateCustomerExists(customer.getName());
		
		Throwable exception = assertThrows(BusinessException.class, ()-> rules.checkIfCorporateCustomerExists(customer.getName()));
		
		 assertEquals(customer.getName()+"Kurumsal müşteri bulunamadı.", exception.getMessage());
	}
	
	@Test
	void testCheckIfCorporateCustomerTaxNumberExists() {
		CorporateCustomer customer = new CorporateCustomer();
		customer.setId(1);
		customer.setName("test");
		customer.setTaxNumber("testnumber");
		
		Mockito.doThrow(new BusinessException(customer.getName()+messageSource.getMessage(IndividualCustomerMessages.Business.notExists, null,LocaleContextHolder.getLocale())))
	       .when(rules).checkIfCorporateCustomerTaxNumberExists(customer.getTaxNumber());
		
		Throwable exception = assertThrows(BusinessException.class, ()-> rules.checkIfCorporateCustomerTaxNumberExists(customer.getTaxNumber()));
		
		 assertEquals(customer.getTaxNumber()+"Kurumsal müşteri bulunamadı.", exception.getMessage());
	}
}
