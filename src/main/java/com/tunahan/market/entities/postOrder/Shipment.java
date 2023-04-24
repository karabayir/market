package com.tunahan.market.entities.postOrder;

import com.tunahan.market.entities.category.CargoCompany;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "shipments")
@Getter
@Setter
@NoArgsConstructor
public class Shipment extends BasePostOrder{
	
	@ManyToOne
	@JoinColumn(name = "cargo_company_id")
	private CargoCompany cargoCompany;
}
