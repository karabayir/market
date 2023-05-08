package com.tunahan.market.seller;

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

import com.tunahan.market.business.concretes.seller.SellerManager;
import com.tunahan.market.core.exceptions.BusinessException;
import com.tunahan.market.core.messages.seller.SellerMessages;
import com.tunahan.market.core.utilities.mapping.ModelMapperManager;
import com.tunahan.market.entities.seller.Seller;
import com.tunahan.market.repository.seller.SellerRepository;
import com.tunahan.market.rules.seller.SellerRules;

@ExtendWith(MockitoExtension.class)
public class SellerManagerTest {
	
	@Mock
	private SellerRules rules;
	
	@Mock
	private SellerRepository repository;

	@Mock
	private ResourceBundleMessageSource messageSource;

	@Mock
	private ModelMapperManager mapperService;
	
	@Mock
	private ModelMapper modelMapper;
	
	@InjectMocks
	private SellerManager manager;
	
	@BeforeEach
	void setUp() {
		messageSource = new ResourceBundleMessageSource();
	    messageSource.setBasenames("messages/seller/SellerMessages");
	    messageSource.setDefaultEncoding("UTF-8");
	    
	    modelMapper = new ModelMapper();
	    mapperService = new ModelMapperManager(modelMapper);       
	}
	
	@Test
	void testCheckIfSellerIdExists() {
		Seller seller = new Seller();
		seller.setId(1);
		
		Mockito.doThrow(new BusinessException(seller.getId()+ messageSource.getMessage(SellerMessages.Business.notExists, null,LocaleContextHolder.getLocale())))
	       .when(rules).checkIfSellerExists(seller.getId());
		
		Throwable exception = assertThrows(BusinessException.class, ()-> rules.checkIfSellerExists(seller.getId()));
		
		 assertEquals(seller.getId()+"Satıcı mevcut değil.", exception.getMessage());
	}
	
	@Test
	void testCheckIfSellerNameExists() {
		Seller seller = new Seller();
		seller.setId(1);
		seller.setName("test");
		
		Mockito.doThrow(new BusinessException(seller.getName()+ messageSource.getMessage(SellerMessages.Business.notExists, null,LocaleContextHolder.getLocale())))
	       .when(rules).checkIfSellerExists(seller.getName());
		
		Throwable exception = assertThrows(BusinessException.class, ()-> rules.checkIfSellerExists(seller.getName()));
		
		 assertEquals(seller.getName()+"Satıcı mevcut değil.", exception.getMessage());
	}
	
	@Test
	void testCheckIfSellerTaxNumberExists() {
		Seller seller = new Seller();
		seller.setId(1);
		seller.setName("test");
		seller.setTaxNumber("testnumber");
		
		Mockito.doThrow(new BusinessException(seller.getTaxNumber()+ messageSource.getMessage(SellerMessages.Business.notExists, null,LocaleContextHolder.getLocale())))
	       .when(rules).checkIfSellerTaxNumberExists(seller.getTaxNumber());
		
		Throwable exception = assertThrows(BusinessException.class, ()-> rules.checkIfSellerTaxNumberExists(seller.getTaxNumber()));
		
		 assertEquals(seller.getTaxNumber()+"Satıcı mevcut değil.", exception.getMessage());
	}
}
