package com.tunahan.market.dtos.responses.order;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateOrderResponse {

	private long id;
	private long customerId;
	private long productId;
	private LocalDate date;
	private int productQuantity;
	private double totalPrice;
	private double discountRate;
}
