package com.tunahan.market.repository.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tunahan.market.entities.product.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	List<Product> findByName(String name);
	
	boolean existsByNameIgnoreCase(String name);
	
	 @Query("select pc.category.id from ProductCategory pc where pc.product.id=:productId")
	  List<Long> findAllCategoriesById(@Param("productId") long productId);
}
