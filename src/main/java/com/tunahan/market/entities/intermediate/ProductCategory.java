package com.tunahan.market.entities.intermediate;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.tunahan.market.entities.category.Category;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product_categories")
@Getter
@Setter
@NoArgsConstructor
public class ProductCategory extends BaseProductIntermediate{

	@ManyToOne
	@JoinColumn(name = "category_id")
	@JsonBackReference
	private Category category;
}
