package com.tunahan.market.core.messages.discount;

public class DiscountMessages {

	public static class Business{
		public static final String  notExists ="discount.not.exists";
	}
	public static class Validation{
		public static  final String nullDiscountName="discount.nullName";
		public static  final String nullDiscountEndDate="discount.nullEndDate";
		public static  final String lengthDiscountName="discount.lengthName";
		public static  final String maxDiscountRate="discount.maximumRate";	
	}
}
