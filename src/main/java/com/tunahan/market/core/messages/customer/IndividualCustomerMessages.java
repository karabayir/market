package com.tunahan.market.core.messages.customer;

public class IndividualCustomerMessages {

	public static class Business{
		public static final String  notExists ="individual.not.exists";
		public static final String  alreadyExistsTCKN = "individual.already.exists";
	}
    public static class Validation{	
		public static  final String nullIndividualEmail="individual.nullMail";
		public static  final String nullIndividualBirthDate="individual.nullBirthDay";
		public static  final String nullIndividualFirstName="individual.nullFirtName";
		public static  final String nullIndividualLastName="individual.nullLastName";
		public static  final String nullIndividualTCKN="individual.nullIdentityNumber";
		public static  final String nullIndividualPhone="individual.nullPhone";
		public static  final String lengthIndividualFirstName="individual.lengthFirstName";
		public static  final String lengthIndividualLastName="individual.lengthLastName";	
		public static  final String lengthIndividualTCKN ="individual.lengthIdentityNumber";
		public static  final String lengthIndividualPhone ="individual.lengthPhone";
	}
    public static class Result{
		public static final String  getAllIndividual ="Individual List";
		public static final String  getIndividualById ="Get Individual By Id";
		public static final String  getIndividualByName ="Get Individual By Name";
		public static final String  getIndividualByTCKN="Get Individual By Tax Number";
		public static final String  addIndividual ="Added Individual";
		public static final String  updateIndividual ="Updated Individual";
		public static final String  deleteIndividual ="Deleted Individual";
		public static final String  getAllIndividualPageable ="Individual List Pageable";
	}
	public static class Controller{
		public static final String  requestMapping="/api/IndividualCustomers/";
		public static final String  getAll="getAll";
		public static final String  getById="getById/{id}";
		public static final String  getByName="getByName";
		public static final String  getByTCKN="getByTCKN";
		public static final String  add="add";
		public static final String  update="update";
		public static final String  deleteById="delete/{id}";
		public static final String  pageable="getAllPageable";
	}
}
