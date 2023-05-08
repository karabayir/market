package com.tunahan.market.entities.preOrder;

import com.tunahan.market.entities.product.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "discounts")
@Getter
@Setter
@NoArgsConstructor
public class Discount extends BasePreOrder{

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	private String name;
	private double rate;
}
