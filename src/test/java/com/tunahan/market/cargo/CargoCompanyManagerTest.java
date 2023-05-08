package com.tunahan.market.cargo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Locale;

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

import com.tunahan.market.business.concretes.cargo.CargoCompanyManager;
import com.tunahan.market.core.exceptions.BusinessException;
import com.tunahan.market.core.messages.cargo.CargoCompanyMessages;
import com.tunahan.market.core.utilities.mapping.ModelMapperManager;
import com.tunahan.market.entities.category.CargoCompany;
import com.tunahan.market.repository.cargo.CargoCompanyRepository;
import com.tunahan.market.rules.cargo.CargoCompanyRules;

@ExtendWith(MockitoExtension.class)
public class CargoCompanyManagerTest {
	
	@Mock
	private CargoCompanyRules rules;

	@Mock
	private CargoCompanyRepository repository;

	@Mock
	private ResourceBundleMessageSource messageSource;

	@Mock
	private ModelMapperManager mapperService;
	
	@Mock
	private ModelMapper modelMapper;
	
	@InjectMocks
	CargoCompanyManager manager;
	
	@BeforeEach
	void setUp() {

		messageSource = new ResourceBundleMessageSource();
	    messageSource.setBasenames("messages/cargoCompany/CargoCompany");
	    messageSource.setDefaultEncoding("UTF-8");
	    
	    modelMapper = new ModelMapper();
	    mapperService = new ModelMapperManager(modelMapper);   
	    
	}
	
	@Test
	void testcheckIfCargoCompanyNameExists() {
		CargoCompany company = new CargoCompany();
		company.setId(1);
		company.setName("kargo");

	    Mockito.doThrow(new BusinessException(company.getName() + messageSource.getMessage(CargoCompanyMessages.Business.notExists, null,LocaleContextHolder.getLocale())))
	       .when(rules).checkIfCargoCompanyNameExists(company.getName());
	    
	    Throwable exception = assertThrows(BusinessException.class, ()-> rules.checkIfCargoCompanyNameExists(company.getName()));
	    
	    assertEquals(company.getName()+"Kargo şirketi bulunamadı.", exception.getMessage());
	}
	
}
