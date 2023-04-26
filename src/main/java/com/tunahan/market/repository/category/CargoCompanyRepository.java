package com.tunahan.market.repository.category;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunahan.market.entities.category.CargoCompany;

public interface CargoCompanyRepository extends JpaRepository<CargoCompany, Long>{

	Optional<CargoCompany> findByName(String name);
	
	boolean existsByNameIgnoreCase(String name);
}
