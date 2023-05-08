package com.tunahan.market.core.messages.category;

public class CategoryMessages  {
	
	public static class Business{
		public static final String  notExists ="category.not.exists";
		public static final String  alreadyExists ="category.already.exists";
	}
	public static class Validation{
		public static  final String nullCategoryName ="category.nullName";	
		public static  final String lengthCategoryName ="category.lengthName";
	}
	public static class Result{
		public static final String  getAllCategory ="Category List";
		public static final String  getCategoryById ="Get Category By Id";
		public static final String  getCategoryByName ="Get Category By Name";
		public static final String  addCategory ="Added Category";
		public static final String  updateCategory ="Updated Category";
		public static final String  deleteCategory ="Deleted Category";
		public static final String  getAllCategoryPageable ="Category List Pageable";
	}
	public static class Controller{
		public static final String  requestMapping="/api/categories/";
		public static final String  getAll="getAll";
		public static final String  getById="getById/{id}";
		public static final String  getByName="getByName";
		public static final String  add="add";
		public static final String  update="update";
		public static final String  deleteById="delete/{id}";
		public static final String  pageable="getAllPageable";
	}
}

