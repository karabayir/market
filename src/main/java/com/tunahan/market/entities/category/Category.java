package com.tunahan.market.entities.category;

import java.util.List;

import com.tunahan.market.entities.product.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="categories")
@Getter
@Setter
@NoArgsConstructor
public class Category extends BaseCategory{
	
	@OneToMany(mappedBy = "category")
	private List<Product> productList;
}
