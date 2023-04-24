package com.tunahan.market.entities.intermediate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.tunahan.market.entities.feature.Color;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product_colors")
@Getter
@Setter
@NoArgsConstructor
public class ProductColor extends BaseProductIntermediate{
	
	@ManyToOne
	@JoinColumn(name = "color_id")
	@JsonBackReference
	private Color color;
}
