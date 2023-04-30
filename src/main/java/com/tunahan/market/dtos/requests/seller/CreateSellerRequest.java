package com.tunahan.market.dtos.requests.seller;

import org.hibernate.validator.constraints.Length;

import com.tunahan.market.core.constant.seller.SellerConstants;
import com.tunahan.market.core.messages.seller.SellerMessages;

import jakarta.validation.constraints.Email;
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
public class CreateSellerRequest{
	
	@NotNull(message = SellerMessages.Validation.nullSellerTaxNumber)
	@Length(
			min = SellerConstants.minLengthSellerTaxNumber,
			max = SellerConstants.maxLengthSellerTaxNumber,
			message = SellerMessages.Validation.lengthSellerTaxNumber)
	@Pattern(regexp = "\\S+")
	private String taxNumber;
	
	@NotNull(message = SellerMessages.Validation.nullSellerName)
	@Length(
			min = SellerConstants.minLengthSellerName,
			max = SellerConstants.maxLengthSellerName,
			message = SellerMessages.Validation.lengthSellerName)
	private String name;
	
	@NotNull(message = SellerMessages.Validation.nullSellerMail)
	@Email
	private String email;

	@NotNull(message = SellerMessages.Validation.nullSellerAddress)
	@Length(
			min = SellerConstants.minLengthSellerAddress,
			max = SellerConstants.maxLengthSellerAddress,
			message = SellerMessages.Validation.lengthSelerAddress)
	private String address;
	
	@NotNull(message = SellerMessages.Validation.nullSellerPhone)
	@Length(
			min=SellerConstants.minLengthPhone, 
			max = SellerConstants.maxLengthPhone,
			message = SellerMessages.Validation.lengthSelerPhone)
	@Pattern(regexp = "\\S+")
	private String phone;
}
