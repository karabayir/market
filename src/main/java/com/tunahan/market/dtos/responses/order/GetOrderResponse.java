package com.tunahan.market.dtos.responses.order;

import java.util.Date;
import java.util.List;

import com.tunahan.market.entities.preOrder.Installment;

public record GetOrderResponse(
		long id,
		long customerId,
		long productId,
		Date date,
		double totalPrice,
		List<Installment> installmentList
		) {

}
