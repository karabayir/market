package com.tunahan.market.payment;

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

import com.tunahan.market.business.concretes.payment.PaymentManager;
import com.tunahan.market.core.exceptions.BusinessException;
import com.tunahan.market.core.messages.payment.PaymentMessages;
import com.tunahan.market.core.utilities.mapping.ModelMapperManager;
import com.tunahan.market.entities.payment.Payment;
import com.tunahan.market.repository.payment.PaymentRepository;
import com.tunahan.market.rules.payment.PaymentRules;

@ExtendWith(MockitoExtension.class)
public class PaymentManagerTest {
	
	@Mock
	private PaymentRules rules;
	
	@Mock
	private PaymentRepository repository;

	@Mock
	private ResourceBundleMessageSource messageSource;

	@Mock
	private ModelMapperManager mapperService;
	
	@Mock
	private ModelMapper modelMapper;
	
	@InjectMocks
	private PaymentManager manager;
	
	@BeforeEach
	void setUp() {
		messageSource = new ResourceBundleMessageSource();
	    messageSource.setBasenames("messages/payment/PaymentMessages");
	    messageSource.setDefaultEncoding("UTF-8");
	    
	    modelMapper = new ModelMapper();
	    mapperService = new ModelMapperManager(modelMapper);       
	}
	
	@Test
	void testCheckIfPaymentExists() {
		Payment payment = new Payment();
		payment.setId(1);
		
		Mockito.doThrow(new BusinessException(payment.getId()+ messageSource.getMessage(PaymentMessages.Business.notExists, null,LocaleContextHolder.getLocale())))
	       .when(rules).checkIfPaymentExists(payment.getId());
		
		Throwable exception = assertThrows(BusinessException.class, ()-> rules.checkIfPaymentExists(payment.getId()));
		
		 assertEquals(payment.getId()+"Ödeme mevcut değil.", exception.getMessage());
	}
}
