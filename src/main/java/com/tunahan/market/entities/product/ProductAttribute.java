package com.tunahan.market.entities.product;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product_attributes")
@Getter
@Setter
@NoArgsConstructor
public class ProductAttribute extends BaseProduct{

	private String attribute;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
}
