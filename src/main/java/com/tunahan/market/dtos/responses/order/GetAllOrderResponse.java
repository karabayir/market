package com.tunahan.market.dtos.responses.order;

import java.util.Date;

public record GetAllOrderResponse(
		long id,
		long customerId,
		long productId,
		Date date,
		double totalPrice
		
		) {

}
