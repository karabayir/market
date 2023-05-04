package com.tunahan.market.repository.category;

import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tunahan.market.dtos.responses.category.GetAllCategoryResponse;
import com.tunahan.market.entities.category.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

  Optional<Category> findByNameIgnoreCase(String name);
  boolean existsByNameIgnoreCase(String name);
  
  
  @Query(value = "Select new " +
          "com.tunahan.market.dtos.responses.category.GetAllCategoryResponse(c.id, c.name) " +
          "From Category c",
          nativeQuery = false)
  Slice<GetAllCategoryResponse> getAll(Pageable pageable);
}
