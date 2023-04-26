package com.tunahan.market.dtos.requests.seller;

public record CreateSellerRequest(
		String taxNumber,
		String name,
		String email,
		String address,
		String phone
		) {

}
