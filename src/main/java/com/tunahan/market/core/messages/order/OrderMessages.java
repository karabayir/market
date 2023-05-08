package com.tunahan.market.core.messages.order;

public class OrderMessages {

	public static class Business{
		public static final String  notExists ="order.not.exists";
	}	
	public static class Validation{
		public static  final String minProductQuantity = "order.minimumProductQuantity";
	}
	public static class Result{
		public static final String  getAllOrder ="Order List";
		public static final String  getOrderById ="Get Order By Id";
		public static final String  addOrder ="Added Order";
		public static final String  updateOrder ="Updated Order";
		public static final String  deleteOrder ="Deleted Order";
		public static final String  getAllOrderPageable ="Order List Pageable";
	}
	public static class Controller{
		public static final String  requestMapping="/api/orders/";
		public static final String  getAll="getAll";
		public static final String  getById="getById/{id}";
		public static final String  add="add";
		public static final String  update="update";
		public static final String  deleteById="delete/{id}";
		public static final String  pageable="getAllPageable";
	}
}
