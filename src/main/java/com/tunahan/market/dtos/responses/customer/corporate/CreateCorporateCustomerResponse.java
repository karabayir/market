package com.tunahan.market.dtos.responses.customer.corporate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCorporateCustomerResponse {

	private long id;
	private String email;
	private String phone;
	private String name;
	private String taxNumber;
}
