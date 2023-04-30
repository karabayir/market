package com.tunahan.market.core.messages.product;

import com.tunahan.market.core.constant.product.ProductConstants;

public class ProductMessages {
	
	public static class Business{
		public static final String  notExists = "Product not exists";
	}
	
	public static class Validation{
		
		public static  final String nullProductName = "Ürün ismi alanı boş olamaz";
		
		public static  final String lengthProductName =
			    "Ürün ismi en az "+ProductConstants.minLengthName+
				" en fazla " +ProductConstants.maxLengthName+
				" uzunluğunda olmalıdır";
		
		public static  final String lengthDescription =
			    "Ürün açıklaması en fazla "+ProductConstants.maxLengthDescription+
				" harf olmalıdır";

		public static  final String minUnitPrice = 
				"Ürün fiyatı "+ProductConstants.minUnitPrice+
				" değerinden düşük olamaz";
		
		public static  final String minStock = 
				"Ürün stoğu "+ProductConstants.minStock+
				" değerinden düşük olamaz";
	}
}
