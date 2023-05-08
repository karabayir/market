package com.tunahan.market.core.messages.comment;

public class ReviewMessages {

	public static class Business{
		public static final String  notExists ="review.not.exists";
	}
	public static class Validation{
		public static  final String nullReview ="review.nullName";	
		public static  final String lengthReview ="review.lengthName";
	}
	public static class Result{
		public static final String  getAllReview ="Review List";
		public static final String  getReviewById ="Get Review By Id";
		public static final String  getReviewByName ="Get Review By Name";
		public static final String  addReview="Added Review";
		public static final String  updateReview ="Updated Review";
		public static final String  deleteReview ="Deleted Review";
		public static final String  getAllReviewPageable ="Review List Pageable";
	}
	public static class Controller{
		public static final String  requestMapping="/api/reviews/";
		public static final String  getAll="getAll";
		public static final String  getById="getById/{id}";
		public static final String  getByName="getByName";
		public static final String  add="add";
		public static final String  update="update";
		public static final String  deleteById="delete/{id}";
		public static final String  pageable="getAllPageable";
	}
}
