package com.tunahan.market.repository.preOrder;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunahan.market.entities.preOrder.Discount;

public interface DiscountRepository extends JpaRepository<Discount, Long>{

	Optional<Discount> findByNameIgnoreCase(String name);
	boolean existsByNameIgnoreCase(String name);
}
