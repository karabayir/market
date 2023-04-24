package com.tunahan.market.entities.payment;

import java.util.Date;
import java.util.List;

import com.tunahan.market.entities.order.Order;
import com.tunahan.market.entities.preOrder.Installment;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	@OneToMany(mappedBy = "payment")
	private List<Installment> installmentList;
	
	private Date date;
	
	@Enumerated(EnumType.STRING)
	private PaymentMethod paymentMethod;
	
	private double totalPrice;
	private String currency;
	
	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;
	
	private String confirmNumber;
}
