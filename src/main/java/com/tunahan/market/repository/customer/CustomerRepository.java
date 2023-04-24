package com.tunahan.market.repository.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tunahan.market.entities.customer.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
