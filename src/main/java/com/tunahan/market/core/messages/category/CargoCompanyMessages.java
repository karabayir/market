package com.tunahan.market.core.messages.category;

import com.tunahan.market.core.constant.category.CargoCompanyConstants;

public class CargoCompanyMessages {

	public static class Business{
		public static final String  notExists = "Cargo Company not exists";
		public static final String  alreadyExists = "Cargo Company already exists";
	}
	
	public static class Validation{
		
		public static  final String nullCargoCompanyName = "Kargo Şirketi ismi alanı boş olamaz";
		
		public static  final String lengthCargoCompanyName =
			    "Kargo şirketi ismi en az "+CargoCompanyConstants.minLengthName+
				" en fazla " +CargoCompanyConstants.maxLengthName+
				" uzunluğunda olmalıdır";
	}
}
