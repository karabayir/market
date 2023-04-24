package com.tunahan.market.repository.address;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunahan.market.entities.address.Location;

public interface LocationRepository extends JpaRepository<Location, Long>{

}
