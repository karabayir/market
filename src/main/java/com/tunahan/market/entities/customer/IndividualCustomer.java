package com.tunahan.market.entities.customer;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "individual_customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IndividualCustomer extends Customer{

	private String TCKN;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
}
