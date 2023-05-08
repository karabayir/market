package com.tunahan.market.core.messages.comment;

public class RereviewMessages {
	
	public static class Business{
		public static final String  notExists ="rereview.not.exists";
	}
	public static class Validation{
		public static  final String nullRereview ="rereview.nullName";	
		public static  final String lengthRereview ="rereview.lengthName";
	}
	public static class Result{
		public static final String  getAllRereview ="Rereview List";
		public static final String  getRereviewById ="Get Rereview By Id";
		public static final String  getRereviewByName ="Get Rereview By Name";
		public static final String  addRereview="Added Rereview";
		public static final String  updateRereview ="Updated Rereview";
		public static final String  deleteRereview ="Deleted Rereview";
		public static final String  getAllRereviewPageable ="Rereview List Pageable";
	}
	public static class Controller{
		public static final String  requestMapping="/api/rereviews/";
		public static final String  getAll="getAll";
		public static final String  getById="getById/{id}";
		public static final String  getByName="getByName";
		public static final String  add="add";
		public static final String  update="update";
		public static final String  deleteById="delete/{id}";
		public static final String  pageable="getAllPageable";
	}
}
