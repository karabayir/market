package com.tunahan.market.dtos.requests.customer;

import org.hibernate.validator.constraints.Length;

import com.tunahan.market.core.constant.customer.CorporateCustomerConstants;
import com.tunahan.market.core.messages.customer.CorporateCustomerMessages;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCorporateCustomerRequest {

	@NotNull
	@NotBlank
	@Email(message = CorporateCustomerMessages.Validation.nullCustomerEmail)
	private String email;
	
	@Length(
			min=CorporateCustomerConstants.minLengthPhone, 
			max = CorporateCustomerConstants.maxLengthPhone,
			message = CorporateCustomerMessages.Validation.lengthCustomerPhone)
	@Pattern(regexp = "\\S+")
	private String phone;
	
	
	@NotNull
	@Length(
			min = CorporateCustomerConstants.minLengthName,
			max = CorporateCustomerConstants.maxLengthName,
			message = CorporateCustomerMessages.Validation.lengthCustomerName)
	private String name;
	
	@Length(
			min=CorporateCustomerConstants.minLengthTaxNumber,
			max=CorporateCustomerConstants.maxLengthTaxNumber,
			message = CorporateCustomerMessages.Validation.lengthCustomerTaxNumber)
	@Pattern(regexp = "\\S+")
	private String taxNumber;
}
