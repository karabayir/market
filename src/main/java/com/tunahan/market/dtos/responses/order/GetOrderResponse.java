package com.tunahan.market.dtos.responses.order;

import java.time.LocalDate;
import java.util.List;

import com.tunahan.market.entities.preOrder.Installment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetOrderResponse{

	private long id;
	private long customerId;
	private long productId;
	private LocalDate date;
	private double totalPrice;
	private int productQuantity;
	private List<Installment> installmentList;
}
