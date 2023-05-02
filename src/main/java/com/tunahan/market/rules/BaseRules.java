package com.tunahan.market.rules;

import org.springframework.context.MessageSource;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class BaseRules {

	protected  MessageSource messageSource;	
}
