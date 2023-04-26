package com.tunahan.market.dtos.requests.order;

import java.util.Date;

public record CreateOrderRequest(
		long customerId,
		long productId,
		Date date,
		double totalPrice
		) {

}
