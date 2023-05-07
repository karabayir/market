package com.tunahan.market.dtos.responses.payment;

import java.time.LocalDate;
import java.util.List;

import com.tunahan.market.entities.payment.PaymentMethod;
import com.tunahan.market.entities.payment.PaymentStatus;
import com.tunahan.market.entities.preOrder.Installment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetPaymentResponse {

	private long id;
	private long orderId;
	private LocalDate date;
	private double totalPrice;
	private String currency;
	private PaymentStatus paymentStatus;
	private PaymentMethod paymentMethod;
	private String confirmNumber;
	private List<Installment> installmentList;
}
