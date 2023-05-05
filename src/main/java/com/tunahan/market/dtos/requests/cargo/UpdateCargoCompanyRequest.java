package com.tunahan.market.dtos.requests.cargo;

import org.hibernate.validator.constraints.Length;

import com.tunahan.market.core.constant.category.CargoCompanyConstants;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCargoCompanyRequest {
	
	@Positive
	private long id;

	@NotNull(message ="{cargoCompany.nullName}")
	@Length(
			min=CargoCompanyConstants.minLengthName,
			max=CargoCompanyConstants.maxLengthName,
			message ="{cargoCompany.lengthName}")
	private String name;
}
