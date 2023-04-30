package com.tunahan.market.core.messages.customer;

import com.tunahan.market.core.constant.customer.IndividualCustomerConstants;

public class IndividualCustomerMessages {

	public static class Business{
		public static final String  notExists = "Individual Customer not exists";
		public static final String  alreadyExistsTCKN = "Individual Customer TKCN already exists";
	}
	
public static class Validation{
		
		public static  final String nullCustomerEmail = "Mail ismi alanı boş olamaz";
		public static  final String nullCustomerBirthDate = "Doğum yılı alanı boş olamaz";
		
		public static  final String lengthCustomerFirstName =
	    "Customer ismi en az "+IndividualCustomerConstants.minLengthFirstName+
		" en fazla " +IndividualCustomerConstants.maxLengthFirstName+
		" uzunluğunda olmalıdır";
		
		public static  final String lengthCustomerLastName =
			    "Customer soyadı en az "+IndividualCustomerConstants.minLengthLastName+
				" en fazla " +IndividualCustomerConstants.maxLengthLastName+
				" uzunluğunda olmalıdır";
		
		public static  final String lengthCustomerTCKN =
			    "Customer kimlik numarası "+IndividualCustomerConstants.lengthTCKN+
				" uzunluğunda olmalıdır";
		
		public static  final String lengthCustomerPhone =
			    " Telefon numarası en az "+IndividualCustomerConstants.minLengthPhone+
				" en fazla " +IndividualCustomerConstants.maxLengthPhone+
				" uzunluğunda olmalıdır";
	}
}
