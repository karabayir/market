package com.tunahan.market.entities.seller;

import java.util.List;

import com.tunahan.market.entities.intermediate.ProductSeller;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sellers")
@Getter
@Setter
@NoArgsConstructor
public class Seller {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String taxNumber;
	private String name;
	private String email;
	private String address;
	private String phone;
	
	@OneToMany(mappedBy ="seller")
	private List<ProductSeller> productSellerList;
	
}
