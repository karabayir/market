package com.tunahan.market.repository.category;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunahan.market.entities.category.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

  Optional<Category> findByName(String name);

  boolean existsByNameIgnoreCase(String name);
}
