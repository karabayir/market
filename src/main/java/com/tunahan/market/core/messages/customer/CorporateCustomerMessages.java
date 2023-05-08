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
    public static class Result{
		public static final String  getAllCorporate ="Corporate List";
		public static final String  getCorporateById ="Get Corporate By Id";
		public static final String  getCorporateByName ="Get Corporate By Name";
		public static final String  getCorporateByTaxNumber="Get Corporate By Tax Number";
		public static final String  addCorporate ="Added Corporate";
		public static final String  updateCorporate ="Updated Corporate";
		public static final String  deleteCorporate ="Deleted Corporate";
		public static final String  getAllCorporatePageable ="Corporate List Pageable";
	}
	public static class Controller{
		public static final String  requestMapping="/api/corporateCustomers/";
		public static final String  getAll="getAll";
		public static final String  getById="getById/{id}";
		public static final String  getByName="getByName";
		public static final String  getByTaxNumber="getByTaxNumber";
		public static final String  add="add";
		public static final String  update="update";
		public static final String  deleteById="delete/{id}";
		public static final String  pageable="getAllPageable";
	}
}
