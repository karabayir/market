package com.tunahan.market.repository.category;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tunahan.market.entities.category.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

  Optional<Category> findByName(String name);

  boolean existsByNameIgnoreCase(String name);
  
  @Query("select pc.product.id from ProductCategory pc where pc.category.id=:categoryId")
  List<Long> findAllProductsById(@Param("categoryId") long categoryId);
}
