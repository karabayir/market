package com.tunahan.market.dtos.requests.order;

import com.tunahan.market.core.constant.order.OrderConstants;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequest{

	@Positive
	private long customerId;
	
	@Positive
	private long productId;
	
	@Min(value = OrderConstants.minTotalPrice,
		 message = "{order.minimumTotalPrice}")
	private double totalPrice;
}
