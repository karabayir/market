package com.tunahan.market.repository.seller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunahan.market.entities.seller.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long>{

	Optional<List<Seller>> findByName(String name);
	Optional<Seller> findByTaxNumber(String taxNumber);
	boolean existsByNameIgnoreCase(String name);
	boolean existsByTaxNumber(String number);
	
}
