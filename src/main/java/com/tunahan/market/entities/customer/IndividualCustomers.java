package com.tunahan.market.entities.customer;

import java.util.Date;

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
public class IndividualCustomers extends Customer{

	private String TCKN;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
}
