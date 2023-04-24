package com.tunahan.market.repository.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunahan.market.entities.customer.CorporateCustomer;

public interface CorporateCustomerRepository extends JpaRepository<CorporateCustomer, Long>{

}
