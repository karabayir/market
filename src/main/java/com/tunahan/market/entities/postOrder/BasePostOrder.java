package com.tunahan.market.entities.postOrder;

import java.util.Date;

import com.tunahan.market.entities.order.Order;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class BasePostOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	private Date sendDate;
	private Date arrivalDate;
	
	@Enumerated(EnumType.STRING)
	private ShipmentStatus shipmentStatus;
}
