package com.tunahan.market.comment;

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

import com.tunahan.market.business.concretes.comment.RereviewManager;
import com.tunahan.market.core.exceptions.BusinessException;
import com.tunahan.market.core.messages.comment.RereviewMessages;
import com.tunahan.market.core.utilities.mapping.ModelMapperManager;
import com.tunahan.market.entities.comment.Rereview;
import com.tunahan.market.repository.comment.RereviewRepository;
import com.tunahan.market.rules.comment.RereviewRules;

@ExtendWith(MockitoExtension.class)
public class RereviewManagerTest {
	
	@Mock
	private RereviewRules rules;
	
	@Mock
	private RereviewRepository repository;
	
	@Mock
	private ResourceBundleMessageSource messageSource;

	@Mock
	private ModelMapperManager mapperService;
	
	@Mock
	private ModelMapper modelMapper;
	
	@InjectMocks
	private RereviewManager manager;
	
	
	@BeforeEach
	void setUp() {
		messageSource = new ResourceBundleMessageSource();
	    messageSource.setBasenames("messages/comment/rereview/RereviewMessages");
	    messageSource.setDefaultEncoding("UTF-8");
	    
	    modelMapper = new ModelMapper();
	    mapperService = new ModelMapperManager(modelMapper);       
	}
	
	@Test
	void testCheckIfRereviewExists() {
		Rereview rereview = new Rereview();
		rereview.setId(1);
		

		Mockito.doThrow(new BusinessException(rereview.getId()+ messageSource.getMessage(RereviewMessages.Business.notExists, null,LocaleContextHolder.getLocale())))
	       .when(rules).checkIfReviewExists(rereview.getId());
		
		Throwable exception = assertThrows(BusinessException.class, ()-> rules.checkIfReviewExists(rereview.getId()));
		
		 assertEquals(rereview.getId()+"Yorum bulunamadı.", exception.getMessage());
	}
	

}
