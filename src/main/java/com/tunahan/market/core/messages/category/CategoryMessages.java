package com.tunahan.market.core.messages.category;

import com.tunahan.market.core.constant.category.CategoryConstants;

public class CategoryMessages  {
	
	public static class Business{
		public static final String  notExists = "category.not.exists";
		public static final String  alreadyExists = "Category already exists";
	}
	
	public static class Validation{
		
		public static  final String nullCategoryName = "Kategori ismi alanı boş olamaz";
		
		public static  final String lengthCategoryName =
	    "Kategori ismi en az "+CategoryConstants.minLengthName+
		" en fazla " +CategoryConstants.maxLengthName+
		" uzunluğunda olmalıdır";
	}

	
}

