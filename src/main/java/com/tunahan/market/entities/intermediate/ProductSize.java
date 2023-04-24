package com.tunahan.market.entities.intermediate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.tunahan.market.entities.feature.Size;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product_sizes")
@Getter
@Setter
@NoArgsConstructor
public class ProductSize extends BaseProductIntermediate{

	@ManyToOne
	@JoinColumn(name = "size_id")
	@JsonBackReference
	private Size size;
}
