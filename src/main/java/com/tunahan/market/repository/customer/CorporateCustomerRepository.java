package com.tunahan.market.repository.customer;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunahan.market.entities.customer.CorporateCustomer;

public interface CorporateCustomerRepository extends JpaRepository<CorporateCustomer, Long>{

	Optional<CorporateCustomer> findByTaxNumber(String taxNumber);
	Optional<List<CorporateCustomer>> findByName(String name);
}
