package com.tunahan.market.repository.intermediate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunahan.market.entities.intermediate.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long>{

}
