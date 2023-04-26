package com.tunahan.market.repository.address;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tunahan.market.entities.address.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

	@Query("from Address a inner join a.location al inner join al.city alc where alc.name=:name")
	List<Address> getAllByCity(String name);
}
