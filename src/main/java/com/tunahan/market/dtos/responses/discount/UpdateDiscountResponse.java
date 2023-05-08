package com.tunahan.market.dtos.responses.discount;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateDiscountResponse {

	private long id;
	private long productId;
	private String name;
	private double rate;
	private LocalDate startDate;
	private LocalDate endDate;
}
