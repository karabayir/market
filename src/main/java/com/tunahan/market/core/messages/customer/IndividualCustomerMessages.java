package com.tunahan.market.core.messages.customer;

public class IndividualCustomerMessages {

	public static class Business{
		public static final String  notExists ="individual.not.exists";
		public static final String  alreadyExistsTCKN = "individual.already.exists";
	}
    public static class Validation{	
		public static  final String nullIndividualEmail="individual.nullMail";
		public static  final String nullIndividualBirthDate="corporate.nullBirthDay";
		public static  final String nullIndividualFirstName="individual.nullFirtName";
		public static  final String nullIndividualLastName="individual.nullLastName";
		public static  final String nullIndividualTCKN="individual.nullIdentityNumber";
		public static  final String nullIndividualPhone="individual.nullPhone";
		public static  final String lengthIndividualFirstName="individual.lengthFirstName";
		public static  final String lengthIndividualLastName="individual.lengthLastName";	
		public static  final String lengthIndividualTCKN ="individual.lengthIdentityNumber";
		public static  final String lengthIndividualPhone ="individual.lengthPhone";
	}
}
