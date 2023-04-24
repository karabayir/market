package com.tunahan.market.repository.address;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunahan.market.entities.address.Country;

public interface CountryRepository extends JpaRepository<Country, Long>{

}
