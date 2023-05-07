package com.tunahan.market.dtos.responses.payment;

import java.time.LocalDate;

import com.tunahan.market.entities.payment.PaymentMethod;
import com.tunahan.market.entities.payment.PaymentStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreatePaymentResponse {
	
	private long id;
	private long orderId;
	private LocalDate date;
	private double totalPrice;
	private String currency;
	private PaymentStatus paymentStatus;
	private PaymentMethod paymentMethod;
	private String confirmNumber;
}
