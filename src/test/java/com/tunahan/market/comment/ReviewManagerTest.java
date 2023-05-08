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

import com.tunahan.market.business.concretes.comment.ReviewManager;
import com.tunahan.market.core.exceptions.BusinessException;
import com.tunahan.market.core.messages.comment.ReviewMessages;
import com.tunahan.market.core.utilities.mapping.ModelMapperManager;
import com.tunahan.market.entities.comment.Review;
import com.tunahan.market.repository.comment.ReviewRepository;
import com.tunahan.market.rules.comment.ReviewRules;

@ExtendWith(MockitoExtension.class)
public class ReviewManagerTest {
	
	@Mock
	private ReviewRules rules;
	
	@Mock
	private ReviewRepository repository;

	@Mock
	private ResourceBundleMessageSource messageSource;

	@Mock
	private ModelMapperManager mapperService;
	
	@Mock
	private ModelMapper modelMapper;
	
	@InjectMocks
	private ReviewManager manager;
	
	
	@BeforeEach
	void setUp() {
		messageSource = new ResourceBundleMessageSource();
	    messageSource.setBasenames("messages/comment/review/ReviewMessages");
	    messageSource.setDefaultEncoding("UTF-8");
	    
	    modelMapper = new ModelMapper();
	    mapperService = new ModelMapperManager(modelMapper);       
	}
	
	@Test
	void testCheckIfReviewExists(){
		Review review = new Review();
		review.setId(1);
		
		Mockito.doThrow(new BusinessException(review.getId()+ messageSource.getMessage(ReviewMessages.Business.notExists, null,LocaleContextHolder.getLocale())))
	       .when(rules).checkIfReviewExists(review.getId());
		
		Throwable exception = assertThrows(BusinessException.class, ()-> rules.checkIfReviewExists(review.getId()));
		
		 assertEquals(review.getId()+"Yorum bulunamadı.", exception.getMessage());
	}
}
