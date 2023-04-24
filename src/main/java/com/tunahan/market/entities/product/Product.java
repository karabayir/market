package com.tunahan.market.entities.product;

import java.util.List;

import com.tunahan.market.entities.intermediate.ProductCategory;
import com.tunahan.market.entities.intermediate.ProductColor;
import com.tunahan.market.entities.intermediate.ProductSeller;
import com.tunahan.market.entities.intermediate.ProductSize;
import com.tunahan.market.entities.order.Order;
import com.tunahan.market.entities.preOrder.Discount;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
public class Product extends BaseProduct{

	private String name;
	private String description;
	private String image;
	private double unitPrice;
	private int    unitsInStock;
	
	@OneToMany(mappedBy = "product")
	private List<ProductAttribute> attributesList;
	
	@OneToMany(mappedBy = "product")
	private List<ProductColor> productColorList;
	
	@OneToMany(mappedBy = "product")
	private List<ProductSize> productSizeList;
	
	@OneToMany(mappedBy = "product")
	private List<ProductCategory> productCategoryList;
	
	@OneToMany(mappedBy = "product")
	private List<ProductSeller> productSellerList;
	
	@OneToMany(mappedBy = "product")
	private List<Order> orderList;
	
	@OneToMany(mappedBy = "product")
	private List<Discount> discountList;
}
