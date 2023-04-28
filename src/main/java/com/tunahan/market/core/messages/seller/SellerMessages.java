package com.tunahan.market.core.messages.seller;

public class SellerMessages {

	public static class Business{
		public static final String  notExists = "Seller not exists";
	}
	
	public static class Validation{
		public static  final String nullSellerTaxNumber= "Satıcı vergi numarası alanı boş olamaz";
		public static  final String nullSellerName= "Satıcı ismi alanı boş olamaz";
		public static  final String nullSellerMail= "Satıcı mail alanı boş olamaz";
		public static  final String nullSellerAddress= "Satıcı adres alanı boş olamaz";
		public static  final String nullSellerPhone= "Satıcı telefon alanı boş olamaz";
		
	}
}
