package com.tunahan.market.dtos.requests.seller;

import org.hibernate.validator.constraints.Length;

import com.tunahan.market.core.constant.seller.SellerConstants;

import jakarta.validation.constraints.Email;
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
public class UpdateSellerRequest {
	
	@Positive
	private long id;

	@NotNull(message ="{seller.nullTaxNumber}")
	@Length(
			min = SellerConstants.minLengthSellerTaxNumber,
			max = SellerConstants.maxLengthSellerTaxNumber,
			message = "{seller.lengthTaxNumber}")
	@Pattern(regexp = "\\S+")
	private String taxNumber;
	
	@NotNull(message ="{seller.nullName}")
	@Length(
			min = SellerConstants.minLengthSellerName,
			max = SellerConstants.maxLengthSellerName,
			message = "{seller.lengthName}")
	private String name;
	
	@NotNull(message ="{seller.nullMail}")
	@Email
	private String email;

	@NotNull(message = "{seller.nullAddress}")
	@Length(
			min = SellerConstants.minLengthSellerAddress,
			max = SellerConstants.maxLengthSellerAddress,
			message ="{seller.lengthAddress}")
	private String address;
	
	@NotNull(message ="{seller.nullPhone}")
	@Length(
			min=SellerConstants.minLengthPhone, 
			max = SellerConstants.maxLengthPhone,
			message = "{seller.lengthPhone}")
	@Pattern(regexp = "\\S+")
	private String phone;
}
