package com.tunahan.market.repository.address;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunahan.market.entities.address.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
