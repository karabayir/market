package com.tunahan.market.repository.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunahan.market.entities.product.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	List<Product> findByNameIgnoreCase(String name);
	
	boolean existsByNameIgnoreCase(String name);
	
}
