package com.tunahan.market.entities.order;
import java.time.LocalDate;
import java.util.List;

import com.tunahan.market.entities.customer.Customer;
import com.tunahan.market.entities.preOrder.Installment;
import com.tunahan.market.entities.product.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@OneToMany(mappedBy = "order")
	private List<Installment> installmentList;
	
	private int productQuantity;
	private LocalDate date = LocalDate.now();
	private double totalPrice;
}
