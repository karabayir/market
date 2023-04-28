package com.tunahan.market.core.messages.order;

import com.tunahan.market.core.constant.order.OrderConstants;

public class OrderMessages {

	public static class Business{
		public static final String  notExists = "Order not exists";
	}
	
	public static class Validation{
		public static  final String nullOrderDate = "Sipariş tarihi alanı boş olamaz";
		
		public static  final String minUnitPrice = 
				"Sipariş toplam fiyatı "+OrderConstants.minTotalPrice+
				" değerinden düşük olamaz";
	}
}
