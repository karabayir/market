package com.tunahan.market.entities.intermediate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.tunahan.market.entities.seller.Seller;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product_sellers")
@Getter
@Setter
@NoArgsConstructor
public class ProductSeller extends BaseProductIntermediate{

	@ManyToOne
	@JoinColumn(name = "seller_id")
	@JsonBackReference
	private Seller seller;
}
