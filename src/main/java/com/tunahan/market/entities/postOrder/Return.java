package com.tunahan.market.entities.postOrder;

import com.tunahan.market.entities.product.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "returns")
@Getter
@Setter
@NoArgsConstructor
public class Return extends BasePostOrder{

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@Enumerated(EnumType.STRING)
	private ReturnReason returnReason;
	
}
