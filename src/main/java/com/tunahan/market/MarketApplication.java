package com.tunahan.market;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import com.tunahan.market.core.exceptions.BusinessException;
import com.tunahan.market.core.utilities.result.ErrorDataResult;

@SpringBootApplication
@RestControllerAdvice
public class MarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketApplication.class, args);
		
	}
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	public MessageSource messageSource() {
	    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	    messageSource.setBasenames(
	    		"messages/category/CategoryMessages",
	    		"messages/cargoCompany/CargoCompany",
	    		"messages/product/ProductMessages"
	    		);
	    messageSource.setDefaultEncoding("UTF-8");
	    return messageSource;
	}
	
	@Bean
	public LocaleResolver localResolver() {
		AcceptHeaderLocaleResolver resolver = new AcceptHeaderLocaleResolver();
		resolver.setDefaultLocale(new Locale("tr"));
		return resolver;
	}
	
	
	@ExceptionHandler //Valid hataları yakarlar
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationsException(MethodArgumentNotValidException exception){
		Map<String, String> validationErrors= new HashMap<>();
		for(FieldError fieldError: exception.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		 ErrorDataResult<Object> result = new ErrorDataResult<Object>(validationErrors,"VALIDATION EXCEPTION");
		return result;
	}
	
	@ExceptionHandler // Business hataları yakalar.
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleBusinessException(BusinessException businessException){
		ErrorDataResult<Object> errorDataResult= new ErrorDataResult<Object>(businessException.getMessage(),"BUSINESS EXCEPTİON");
		return errorDataResult;
	}

}
