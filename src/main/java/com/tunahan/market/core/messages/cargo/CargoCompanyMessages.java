package com.tunahan.market.core.messages.cargo;

public class CargoCompanyMessages {

	public static class Business{
		public static final String  notExists = "cargoCompany.not.exists";
		public static final String  alreadyExists = "cargoCompany.already.exists";
	}	
	public static class Validation{	
		public static  final String nullCargoCompanyName = "cargoCompany.nullName";
		public static  final String lengthCargoCompanyName ="cargoCompany.lengthName";	   
	}
	public static class Result{
		public static final String  getAllCargo = "Cargo Company List";
		public static final String  getCargoById = "Get Cargo Company By Id";
		public static final String  getCargoByName = "Get Cargo Company By Name";
		public static final String  addCargoCompany = "Added Cargo Company";
		public static final String  updateCargoCompany = "Updated Cargo Company";
		public static final String  deleteCargoCompany = "Deleted Cargo Company";
		public static final String  getAllCargoPageable = "Cargo Company List Pageable";
	}
	public static class Controller{
		public static final String  requestMapping="/api/cargoCompanies/";
		public static final String  getAll="getAll";
		public static final String  getById="getById/{id}";
		public static final String  getByName="getByName";
		public static final String  add="add";
		public static final String  update="update";
		public static final String  deleteById="delete/{id}";
		public static final String  pageable="getAllPageable";
	}
}
