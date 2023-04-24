package com.tunahan.market.repository.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunahan.market.entities.customer.IndividualCustomers;

public interface IndividualCustomerRepository extends JpaRepository<IndividualCustomers, Long>{

}
