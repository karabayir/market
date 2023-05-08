package com.tunahan.market.core.messages.product;

public class ProductMessages {
	
	public static class Business{
		public static final String  notExists = "product.not.exists";
	}
	public static class Validation{
		public static  final String nullProductName ="product.nullName";
		public static  final String nullProductDescription ="product.nullDescription";
		public static  final String lengthProductName ="product.lengthName";
		public static  final String lengthDescription ="product.lengthDescription";
		public static  final String minUnitPrice ="product.minimumUnitPrice";
		public static  final String minStock ="product.minimumStock";
	}
	public static class Result{
		public static final String  getAllProduct ="Product List";
		public static final String  getProductById ="Get Product By Id";
		public static final String  getProductByName ="Get Product By Name";
		public static final String  addProduct ="Added Product";
		public static final String  updateProduct ="Updated Product";
		public static final String  deleteProduct ="Deleted Product";
		public static final String  getAllProductPageable ="Product List Pageable";
	}
	public static class Controller{
		public static final String  requestMapping="/api/products/";
		public static final String  getAll="getAll";
		public static final String  getById="getById/{id}";
		public static final String  getByName="getByName";
		public static final String  add="add";
		public static final String  update="update";
		public static final String  deleteById="delete/{id}";
		public static final String  pageable="getAllPageable";
	}
}
