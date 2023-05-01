package com.tunahan.market.entities.product;

import java.util.List;

import com.tunahan.market.entities.category.Category;
import com.tunahan.market.entities.feature.Color;
import com.tunahan.market.entities.feature.Size;
import com.tunahan.market.entities.order.Order;
import com.tunahan.market.entities.preOrder.Discount;
import com.tunahan.market.entities.seller.Seller;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "color_id")
	private Color color;
	
	@ManyToOne
	@JoinColumn(name = "size_id")
	private Size size;
	
	@ManyToOne
	@JoinColumn(name = "seller_id")
	private Seller seller;
	
	@OneToMany(mappedBy = "product")
	private List<ProductAttribute> attributesList;
	
	@OneToMany(mappedBy = "product")
	private List<Order> orderList;
	
	@OneToMany(mappedBy = "product")
	private List<Discount> discountList;
}
