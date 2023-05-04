package com.tunahan.market;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tunahan.market.core.exceptions.BusinessException;
import com.tunahan.market.core.utilities.result.ErrorDataResult;

@SpringBootApplication
@RestControllerAdvice
public class MarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketApplication.class, args);	
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class) //Valid hataları yakarlar
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationsException(MethodArgumentNotValidException exception){
		Map<String, String> validationErrors= new HashMap<>();
		for(FieldError fieldError: exception.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		 ErrorDataResult<Object> result = new ErrorDataResult<Object>(validationErrors,"VALIDATION EXCEPTION");
		return result;
	}
	
	@ExceptionHandler(BusinessException.class) // Business hataları yakalar.
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleBusinessException(BusinessException businessException){
		ErrorDataResult<Object> errorDataResult= new ErrorDataResult<Object>(businessException.getMessage(),"BUSINESS EXCEPTİON");
		return errorDataResult;
	}

}
