package com.tunahan.market.dtos.responses.order;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderResponse{

	private long id;
	private long customerId;
	private long productId;
	private Date date;
	private double totalPrice;
}
