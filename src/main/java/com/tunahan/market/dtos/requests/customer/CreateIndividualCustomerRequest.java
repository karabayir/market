package com.tunahan.market.dtos.requests.customer;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tunahan.market.core.constant.customer.IndividualCustomerConstants;

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

	@NotNull
	@NotBlank
	@Email
	private String email;
	
	@Length(
			min=IndividualCustomerConstants.minLengthPhone, 
			max = IndividualCustomerConstants.maxLengthPhone)
	@Pattern(regexp = "\\S+")
	private String phone;
	
	@Length(
			min=IndividualCustomerConstants.lengthTCKN,
			max=IndividualCustomerConstants.lengthTCKN)
	@Pattern(regexp = "\\S+")
	private String TCKN;
	
	@NotNull
	@Length(
			min = IndividualCustomerConstants.minLengthFirstName,
			max = IndividualCustomerConstants.maxLengthFirstName)
	private String firstName;
	
	@NotNull
	@Length(
			min = IndividualCustomerConstants.minLengthLastName,
			max = IndividualCustomerConstants.maxLengthLastName)
	private String lastName;
	
	@NotNull
	@JsonFormat(pattern = "dd.MM.yyyy")
	private LocalDate dateOfBirth;
}
