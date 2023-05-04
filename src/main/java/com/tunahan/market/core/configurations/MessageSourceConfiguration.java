package com.tunahan.market.core.configurations;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@Configuration
public class MessageSourceConfiguration {

	@Bean
	public MessageSource messageSource() {
	    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	    messageSource.setBasenames(
	    		"messages/category/CategoryMessages",
	    		"messages/cargoCompany/CargoCompany",
	    		"messages/product/ProductMessages",
	    		"messages/order/OrderMessages",
	    		"messages/seller/SellerMessages",
	    		"messages/customer/corporate/CorporateMessages",
	    		"messages/customer/individual/IndividualMessages",
	    		"messages/customer/customer/CustomerMessages"
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
}
