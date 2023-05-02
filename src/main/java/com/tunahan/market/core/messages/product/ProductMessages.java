package com.tunahan.market.core.messages.product;

public class ProductMessages {
	
	public static class Business{
		public static final String  notExists = "product.not.exists";
	}
	public static class Validation{
		public static  final String nullProductName ="product.nullName";
		public static  final String nullProductDescription ="product.nullDescription";
		public static  final String lengthProductName ="product.lengthName";
		public static  final String lengthDescription ="product.lengthDescription";
		public static  final String minUnitPrice ="product.minimumUnitPrice";
		public static  final String minStock ="product.minimumStock";
	}
}
