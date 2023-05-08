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
	public static class Result{
		public static final String  getAllSeller ="Seller List";
		public static final String  getSellerById ="Get Seller By Id";
		public static final String  getSellerByName ="Get Seller By Name";
		public static final String  getSellerByTaxNumber="Get Seller By Tax Number";
		public static final String  addSeller ="Added Seller";
		public static final String  updateSeller ="Updated Seller";
		public static final String  deleteSeller ="Deleted Seller";
		public static final String  getAllSellerPageable ="Seller List Pageable";
	}
	public static class Controller{
		public static final String  requestMapping="/api/sellers/";
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
