package com.tunahan.market.core.messages.cargo;

public class CargoCompanyMessages {

	public static class Business{
		public static final String  notExists = "cargoCompany.not.exists";
		public static final String  alreadyExists = "cargoCompany.already.exists";
	}	
	public static class Validation{	
		public static  final String nullCargoCompanyName = "cargoCompany.nullName";
		public static  final String lengthCargoCompanyName ="cargoCompany.lengthName";	   
	}
}
