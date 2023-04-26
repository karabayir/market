package com.tunahan.market.dtos.responses.seller;

public record GetSellerResponse(
		long id,
		String taxNumber,
		String name,
		String email,
		String address,
		String phone
		) {

}
