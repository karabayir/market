package com.tunahan.market.dtos.responses.order;

import java.util.Date;
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
	private Date date;
	private double totalPrice;
	private List<Installment> installmentList;
}