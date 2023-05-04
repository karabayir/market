package com.tunahan.market.core.messages.customer;

public class CorporateCustomerMessages {

	public static class Business{
		public static final String  notExists ="corporate.not.exists";
		public static final String  alreadyExistsTaxNumber="corporate.already.exists";
	}
    public static class Validation{	
		public static  final String nullCorporateEmail="corporate.nullMail";
		public static  final String nullCorporateName="corporate.nullName";
		public static  final String nullCorporatePhone="corporate.nullPhone";
		public static  final String nullCorporateTaxNumber="corporate.nullTaxNumber";
		public static  final String lengthCorporateName="corporate.lengthName";
		public static  final String lengthCorporatePhone="corporate.lengthPhone";
		public static  final String lengthCorporateTaxNumber="corporate.lengthTaxNumber";
    }
}
