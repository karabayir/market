package com.tunahan.market.dtos.requests.seller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateSellerRequest{
	private String taxNumber;
	private String name;
	private String email;
	private String address;
	private String phone;
}
