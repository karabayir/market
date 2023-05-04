package com.tunahan.market.core.messages.seller;

public class SellerMessages {

	public static class Business{
		public static final String  notExists = "seller.not.exists";
		public static final String alreadyExists = "seller.already.exists";
	}	
	public static class Validation{	
		public static  final String nullSellerTaxNumber="seller.nullTaxNumber";
		public static  final String nullSellerName="seller.nullName";
		public static  final String nullSellerMail="seller.nullMail";
		public static  final String nullSellerAddress="seller.nullAddress";
		public static  final String nullSellerPhone="seller.nullPhone";	
		public static  final String lengthSellerTaxNumber="seller.lengthTaxNumber";	
		public static  final String lengthSellerName="seller.lengthName";
		public static  final String lengthSelerPhone="seller.lengthPhone";		
		public static  final String lengthSelerAddress="seller.lengthAddress";
	}
	
}
