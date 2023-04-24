package com.tunahan.market.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunahan.market.entities.product.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
