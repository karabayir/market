package com.tunahan.market.dtos.requests.order;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequest{

	private long customerId;
	private long productId;
	private Date date;
	private double totalPrice;
}
