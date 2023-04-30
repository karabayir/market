package com.tunahan.market.dtos.requests.customer;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tunahan.market.core.constant.customer.IndividualCustomerConstants;
import com.tunahan.market.core.messages.customer.IndividualCustomerMessages;

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
public class CreateIndividualCustomerRequest {

	@NotNull(message = IndividualCustomerMessages.Validation.nullCustomerEmail)
	@NotBlank
	@Email
	private String email;
	
	@Length(
			min=IndividualCustomerConstants.minLengthPhone, 
			max = IndividualCustomerConstants.maxLengthPhone,
			message = IndividualCustomerMessages.Validation.lengthCustomerPhone)
	@Pattern(regexp = "\\S+")
	private String phone;
	
	@Length(
			min=IndividualCustomerConstants.lengthTCKN,
			max=IndividualCustomerConstants.lengthTCKN,
			message = IndividualCustomerMessages.Validation.lengthCustomerTCKN)
	@Pattern(regexp = "\\S+")
	private String TCKN;
	
	@NotNull
	@Length(
			min = IndividualCustomerConstants.minLengthFirstName,
			max = IndividualCustomerConstants.maxLengthFirstName,
			message = IndividualCustomerMessages.Validation.lengthCustomerFirstName)
	private String firstName;
	
	@NotNull
	@Length(
			min = IndividualCustomerConstants.minLengthLastName,
			max = IndividualCustomerConstants.maxLengthLastName,
			message = IndividualCustomerMessages.Validation.lengthCustomerLastName)
	private String lastName;
	
	@NotNull(message = IndividualCustomerMessages.Validation.nullCustomerBirthDate)
	@JsonFormat(pattern = "dd.MM.yyyy")
	private LocalDate dateOfBirth;
}
