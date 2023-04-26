package com.tunahan.market.repository.seller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunahan.market.entities.seller.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long>{

	List<Seller> findByName(String name);
	
	boolean existsByNameIgnoreCase(String name);
}
