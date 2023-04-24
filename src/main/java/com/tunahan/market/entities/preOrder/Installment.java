package com.tunahan.market.entities.preOrder;

import com.tunahan.market.entities.order.Order;
import com.tunahan.market.entities.payment.Payment;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "installments")
@Getter
@Setter
@NoArgsConstructor
public class Installment extends BasePreOrder{

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "payment_id")
	private Payment payment;
	
	private int number;

	
}
