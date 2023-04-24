package com.tunahan.market.entities.customer;

import java.util.List;

import com.tunahan.market.entities.address.Address;
import com.tunahan.market.entities.address.Location;
import com.tunahan.market.entities.order.Order;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String email;
	private String phone;
	
	@OneToMany(mappedBy = "customer")
	private List<Location> locationList;
	
	@OneToMany(mappedBy = "customer")
	private List<Address> addressList;
	
	@OneToMany(mappedBy = "customer")
	private List<Order> orderList;
	
	
}
