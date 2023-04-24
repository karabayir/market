package com.tunahan.market.entities.feature;

import java.util.List;

import com.tunahan.market.entities.intermediate.ProductSize;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sizes")
@Getter
@Setter
@NoArgsConstructor
public class Size extends BaseFeature{

	@OneToMany(mappedBy = "size")
	private List<ProductSize> productSizeList;
}
