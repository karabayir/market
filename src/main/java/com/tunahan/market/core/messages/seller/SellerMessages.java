package com.tunahan.market.core.messages.seller;

import com.tunahan.market.core.constant.seller.SellerConstants;

public class SellerMessages {

	public static class Business{
		public static final String  notExists = "Seller not exists";
		public static final String alreadyExists = "Seller already exists";
	}
	
	public static class Validation{
		
		public static  final String nullSellerTaxNumber= "Satıcı vergi numarası alanı boş olamaz";
		public static  final String nullSellerName= "Satıcı ismi alanı boş olamaz";
		public static  final String nullSellerMail= "Satıcı mail alanı boş olamaz";
		public static  final String nullSellerAddress= "Satıcı adres alanı boş olamaz";
		public static  final String nullSellerPhone= "Satıcı telefon alanı boş olamaz";
		
		public static  final String lengthSellerTaxNumber =
			    " Vergi numarası en az "+SellerConstants.minLengthSellerTaxNumber+
				" en fazla " +SellerConstants.maxLengthSellerTaxNumber+
				" uzunluğunda olmalıdır";
		
		public static  final String lengthSellerName =
			    "Müşteri ismi en az "+SellerConstants.minLengthSellerName+
				" en fazla " +SellerConstants.maxLengthSellerName+
				" uzunluğunda olmalıdır";
		
		public static  final String lengthSelerPhone =
			    " Telefon numarası en az "+SellerConstants.minLengthPhone+
				" en fazla " +SellerConstants.maxLengthPhone+
				" uzunluğunda olmalıdır";
		
		public static  final String lengthSelerAddress =
			    " Adres  en az "+SellerConstants.minLengthSellerAddress+
				" en fazla " +SellerConstants.maxLengthSellerAddress+
				" uzunluğunda olmalıdır";
	}
	
}
