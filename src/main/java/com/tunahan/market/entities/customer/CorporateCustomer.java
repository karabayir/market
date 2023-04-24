package com.tunahan.market.entities.customer;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "corporate_customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CorporateCustomer extends Customer{

	private String name;
	private String taxNumber;
	
}
