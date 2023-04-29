package com.tunahan.market.repository.customer;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunahan.market.entities.customer.IndividualCustomer;

public interface IndividualCustomerRepository extends JpaRepository<IndividualCustomer, Long>{

	Optional<IndividualCustomer> findByTCKN(String TCKN);
	Optional<List<IndividualCustomer>> findByFirstNameIgnoreCase(String firstName);
	boolean existsByFirstName(String firstName);
	boolean existsByTCKN(String TCKN);
}
