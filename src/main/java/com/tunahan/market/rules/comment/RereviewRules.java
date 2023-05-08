package com.tunahan.market.rules.comment;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.tunahan.market.core.exceptions.BusinessException;
import com.tunahan.market.core.messages.comment.RereviewMessages;
import com.tunahan.market.entities.comment.CommentStatus;
import com.tunahan.market.entities.comment.Rereview;
import com.tunahan.market.repository.comment.RereviewRepository;
import com.tunahan.market.rules.BaseRules;

@Service
public class RereviewRules extends BaseRules{

	private final RereviewRepository repository;

	public RereviewRules(MessageSource messageSource, RereviewRepository repository) {
		super(messageSource);
		this.repository = repository;
	}
	
	public void checkIfReviewExists(long id) {
		if(!repository.existsById(id))
			throw new BusinessException(id+messageSource.getMessage(RereviewMessages.Business.notExists, null, LocaleContextHolder.getLocale()));
	}
	
	public void checkIfReviewSlang(Rereview rereview) {
		
		String[] slangs = {"salak","aptal","gerizekalı","alçak","puşt"};
		String comment=rereview.getComment();
		for(String slang : slangs) {
			if(comment.toLowerCase().contains(slang) || comment.toUpperCase().contains(slang)) {
				rereview.setCommentStatus(CommentStatus.REJECTED);
				break;}		
			else {
				rereview.setCommentStatus(CommentStatus.CONFIRMED);
			}
							
		}    
	}
}
