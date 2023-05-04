package com.tunahan.market.dtos.requests.customer.individual;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tunahan.market.core.constant.customer.IndividualCustomerConstants;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@NotNull
@AllArgsConstructor
public class UpdateIndividualCustomerRequest {
	
	@Positive
	private long id;

	@NotNull(message ="{individual.nullMail}")
	@NotBlank
	@Email
	private String email;
	
	@NotNull(message ="{individual.nullPhone}")
	@Length(
			min=IndividualCustomerConstants.minLengthPhone, 
			max = IndividualCustomerConstants.maxLengthPhone,
			message ="{individual.lengthPhone}")
	@Pattern(regexp = "\\S+")
	private String phone;
	
	@NotNull(message ="{individual.nullIdentityNumber}")
	@Length(
			min=IndividualCustomerConstants.lengthTCKN,
			max=IndividualCustomerConstants.lengthTCKN,
			message = "{individual.lengthIdentityNumber}")
	@Pattern(regexp = "\\S+")
	private String TCKN;
	
	@NotNull(message ="{individual.nullFirtName}")
	@Length(
			min = IndividualCustomerConstants.minLengthFirstName,
			max = IndividualCustomerConstants.maxLengthFirstName,
			message ="{individual.lengthFirstName}")
	private String firstName;
	
	@NotNull(message ="{individual.nullLastName}")
	@Length(
			min = IndividualCustomerConstants.minLengthLastName,
			max = IndividualCustomerConstants.maxLengthLastName,
			message ="{individual.lengthLastName}")
	private String lastName;
	
	@NotNull(message ="{individual.nullBirthDay}")
	@JsonFormat(pattern = "dd.MM.yyyy")
	private LocalDate dateOfBirth;
}
