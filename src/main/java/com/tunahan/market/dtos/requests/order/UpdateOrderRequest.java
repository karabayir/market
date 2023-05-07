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
public class UpdateOrderRequest {

	@Positive
	long id;
	
	@Positive
	private long customerId;
	
	@Positive
	private long productId;
	
	@Min(value = OrderConstants.minProductQuantity,
		 message = "{order.minimumProductQuantity}")
	private int productQuantity;
}
