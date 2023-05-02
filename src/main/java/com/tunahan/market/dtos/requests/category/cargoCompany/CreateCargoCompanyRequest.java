package com.tunahan.market.dtos.requests.category.cargoCompany;

import org.hibernate.validator.constraints.Length;

import com.tunahan.market.core.constant.category.CargoCompanyConstants;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCargoCompanyRequest {

	@NotNull(message ="{cargoCompany.nullName}")
	@Length(
			min=CargoCompanyConstants.minLengthName,
			max=CargoCompanyConstants.maxLengthName,
			message ="{cargoCompany.lengthName}")
	private String name;
}
