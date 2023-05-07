package com.tunahan.market.core.messages.payment;

public class PaymentMessages {
	public static class Business{
		public static final String  notExists ="payment.not.exists";
	}
	public static class Validation{
		public static  final String minUnitPrice ="payment.minimumTotalPrice";
		public static  final String nullPaymentCurrency ="payment.nullCurrency";	
	}
}
