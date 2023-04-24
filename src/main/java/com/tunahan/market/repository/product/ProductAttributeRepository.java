package com.tunahan.market.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunahan.market.entities.product.ProductAttribute;

public interface ProductAttributeRepository extends JpaRepository<ProductAttribute, Long>{

}
