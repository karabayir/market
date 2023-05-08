package com.tunahan.market.dtos.requests.payment;

import org.hibernate.validator.constraints.Length;

import com.tunahan.market.core.constant.payment.PaymentConstants;
import com.tunahan.market.entities.payment.PaymentMethod;

import jakarta.validation.constraints.Min;
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
public class CreatePaymentRequest {

	@Positive
	private long orderId;
	
	@Min(value =PaymentConstants.minTotalPrice,
		 message ="{payment.minimumTotalPrice}")
	private double totalPrice;
	
	@NotNull(message ="{payment.nullCurrency}")
	@Length(min =PaymentConstants.minLengthCurrency,
	        max =PaymentConstants.maxLengthCurrency,
	        message ="{payment.lengthCurrency}")
	private String currency;
	
	private PaymentMethod paymentMethod;
	private String confirmNumber;
}
