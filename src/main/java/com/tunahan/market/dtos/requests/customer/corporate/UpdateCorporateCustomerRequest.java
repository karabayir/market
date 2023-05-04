package com.tunahan.market.dtos.requests.customer.corporate;

import org.hibernate.validator.constraints.Length;

import com.tunahan.market.core.constant.customer.CorporateCustomerConstants;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCorporateCustomerRequest {
	
	@Positive
	private long id;

	@NotNull(message ="{corporate.nullMail}")
	@NotBlank
	@Email
	private String email;
	
	@NotNull(message = "{corporate.nullPhone}")
	@Length(
			min=CorporateCustomerConstants.minLengthPhone, 
			max = CorporateCustomerConstants.maxLengthPhone,
			message ="{corporate.lengthPhone}")
	@Pattern(regexp = "\\S+")
	private String phone;
	
	@NotNull(message ="{corporate.nullName}")
	@Length(
			min = CorporateCustomerConstants.minLengthName,
			max = CorporateCustomerConstants.maxLengthName,
			message ="{corporate.lengthName}")
	private String name;
	
	@NotNull(message ="{corporate.nullTaxNumber}")
	@Length(
			min=CorporateCustomerConstants.minLengthTaxNumber,
			max=CorporateCustomerConstants.maxLengthTaxNumber,
			message = "{corporate.lengthTaxNumber}")
	@Pattern(regexp = "\\S+")
	private String taxNumber;
}
