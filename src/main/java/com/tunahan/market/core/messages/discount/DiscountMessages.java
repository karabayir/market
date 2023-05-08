package com.tunahan.market.core.messages.discount;

public class DiscountMessages {

	public static class Business{
		public static final String  notExists ="discount.not.exists";
	}
	public static class Validation{
		public static  final String nullDiscountName="discount.nullName";
		public static  final String nullDiscountEndDate="discount.nullEndDate";
		public static  final String lengthDiscountName="discount.lengthName";
		public static  final String maxDiscountRate="discount.maximumRate";	
	}
	public static class Result{
		public static final String  getAllDiscount ="Discount List";
		public static final String  getDiscountById ="Get Discount By Id";
		public static final String  getDiscountByName ="Get Discount By Name";
		public static final String  addDiscount ="Added Discount";
		public static final String  updateDiscount ="Updated Discount";
		public static final String  deleteDiscount ="Deleted Discount";
		public static final String  getAllDiscountPageable ="Discount List Pageable";
	}
	public static class Controller{
		public static final String  requestMapping="/api/discounts/";
		public static final String  getAll="getAll";
		public static final String  getById="getById/{id}";
		public static final String  getByName="getByName";
		public static final String  add="add";
		public static final String  update="update";
		public static final String  deleteById="delete/{id}";
		public static final String  pageable="getAllPageable";
	}
}
