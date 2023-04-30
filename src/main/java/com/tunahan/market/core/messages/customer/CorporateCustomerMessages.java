package com.tunahan.market.core.messages.customer;

import com.tunahan.market.core.constant.customer.CorporateCustomerConstants;

public class CorporateCustomerMessages {

	public static class Business{
		public static final String  notExists = "Corporate Customer not exists";
		public static final String  alreadyExistsTaxNumber = "Corporate Customer Tax Number already exists";
	}
	
public static class Validation{
		
		public static  final String nullCustomerEmail = "Mail ismi alanı boş olamaz";
		
		public static  final String lengthCustomerName =
	    "Müşteri ismi en az "+CorporateCustomerConstants.minLengthName+
		" en fazla " +CorporateCustomerConstants.maxLengthName+
		" uzunluğunda olmalıdır";
		
		public static  final String lengthCustomerPhone =
			    " Telefon numarası en az "+CorporateCustomerConstants.minLengthPhone+
				" en fazla " +CorporateCustomerConstants.maxLengthPhone+
				" uzunluğunda olmalıdır";
		
		public static  final String lengthCustomerTaxNumber =
			    " Vergi numarası en az "+CorporateCustomerConstants.minLengthTaxNumber+
				" en fazla " +CorporateCustomerConstants.maxLengthTaxNumber+
				" uzunluğunda olmalıdır";
    }
}
