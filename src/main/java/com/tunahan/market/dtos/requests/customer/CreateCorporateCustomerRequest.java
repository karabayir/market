package com.tunahan.market.dtos.requests.customer;

import org.hibernate.validator.constraints.Length;

import com.tunahan.market.core.constant.customer.CorporateCustomerConstants;
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
	@Email
	private String email;
	
	@Length(
			min=CorporateCustomerConstants.minLengthPhone, 
			max = CorporateCustomerConstants.maxLengthPhone)
	@Pattern(regexp = "\\S+")
	private String phone;
	
	
	@NotNull
	@Length(
			min = CorporateCustomerConstants.minLengthName,
			max = CorporateCustomerConstants.maxLengthName)
	private String name;
	
	@Length(
			min=CorporateCustomerConstants.minLengthTaxNumber,
			max=CorporateCustomerConstants.maxLengthTaxNumber)
	@Pattern(regexp = "\\S+")
	private String taxNumber;
}
