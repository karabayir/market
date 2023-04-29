package com.tunahan.market.dtos.requests.order;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tunahan.market.core.messages.order.OrderMessages;

import jakarta.validation.constraints.NotNull;
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
	
	@NotNull(message = OrderMessages.Validation.nullOrderDate)
	@JsonFormat(pattern = "dd.MM.yyyy")
	private LocalDate date;
	
	@Positive(message = OrderMessages.Validation.minUnitPrice)
	private double totalPrice;
}
