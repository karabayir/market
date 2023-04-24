package com.tunahan.market.entities.feature;

import java.util.List;

import com.tunahan.market.entities.intermediate.ProductColor;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "colors")
@Getter
@Setter
@NoArgsConstructor
public class Color extends BaseFeature{

	@OneToMany(mappedBy = "color")
	private List<ProductColor> productColorList;
}
