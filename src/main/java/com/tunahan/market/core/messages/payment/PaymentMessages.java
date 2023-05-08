package com.tunahan.market.core.messages.payment;

public class PaymentMessages {
	public static class Business{
		public static final String  notExists ="payment.not.exists";
	}
	public static class Validation{
		public static  final String minUnitPrice ="payment.minimumTotalPrice";
		public static  final String nullPaymentCurrency ="payment.nullCurrency";	
	}
	public static class Result{
		public static final String  getAllPayment ="Payment List";
		public static final String  getPaymentById ="Get Payment By Id";
		public static final String  getPaymentByConfirmNumber="Get Payment By Confirm Number";
		public static final String  addPayment ="Added Payment";
		public static final String  updatePayment ="Updated Payment";
		public static final String  deletePayment ="Deleted Payment";
		public static final String  getAllPaymentPageable ="Payment List Pageable";
	}
	public static class Controller{
		public static final String  requestMapping="/api/payments/";
		public static final String  getAll="getAll";
		public static final String  getById="getById/{id}";
		public static final String  getByConfirmNumber="getByConfirmNumber";
		public static final String  add="add";
		public static final String  update="update";
		public static final String  deleteById="delete/{id}";
		public static final String  pageable="getAllPageable";
	}
}
