package com.tunahan.market.entities.category;

import java.util.List;

import com.tunahan.market.entities.postOrder.Shipment;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cargo_companies")
@Getter
@Setter
@NoArgsConstructor
public class CargoCompany extends BaseCategory{

	@OneToMany(mappedBy = "cargoCompany")
	private List<Shipment> shipmentList;	
}
