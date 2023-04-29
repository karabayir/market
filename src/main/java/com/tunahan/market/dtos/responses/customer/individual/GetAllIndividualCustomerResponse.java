package com.tunahan.market.dtos.responses.customer.individual;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetAllIndividualCustomerResponse {

	private long id;
	private String email;
	private String phone;
	private String TCKN;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
}
