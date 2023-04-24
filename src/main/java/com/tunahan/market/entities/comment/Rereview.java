package com.tunahan.market.entities.comment;

import com.tunahan.market.entities.customer.Customer;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "rereviews")
@Getter
@Setter
@NoArgsConstructor
public class Rereview extends BaseComment{
	
	@ManyToOne
	@JoinColumn(name = "review_id")
	private Review review;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
}
