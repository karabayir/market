package com.tunahan.market.rules.comment;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.tunahan.market.core.exceptions.BusinessException;
import com.tunahan.market.core.messages.comment.ReviewMessages;
import com.tunahan.market.entities.comment.CommentStatus;
import com.tunahan.market.entities.comment.Review;
import com.tunahan.market.repository.comment.ReviewRepository;
import com.tunahan.market.rules.BaseRules;

@Service
public class ReviewRules extends BaseRules{

	private final ReviewRepository repository;

	public ReviewRules(MessageSource messageSource, ReviewRepository repository) {
		super(messageSource);
		this.repository = repository;
	}
	
	public void checkIfReviewExists(long id) {
		if(!repository.existsById(id))
			throw new BusinessException(id+messageSource.getMessage(ReviewMessages.Business.notExists, null, LocaleContextHolder.getLocale()));
	}
	
	public void checkIfReviewSlang(Review review) {
		String[] slangs = {"salak","aptal","gerizekalı","alçak","puşt"};
		String comment=review.getComment();
		for(String slang : slangs) {
			if(comment.toLowerCase().contains(slang) || comment.toUpperCase().contains(slang)) {
				review.setCommentStatus(CommentStatus.REJECTED);
				break;}		
			else {
				review.setCommentStatus(CommentStatus.CONFIRMED);
			}
							
		}    
	}
}
