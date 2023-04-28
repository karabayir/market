package com.tunahan.market.dtos.requests.category.cargoCompany;

import org.hibernate.validator.constraints.Length;

import com.tunahan.market.core.constant.category.CargoCompanyConstants;
import com.tunahan.market.core.messages.category.CargoCompanyMessages;

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

	@NotNull(message = CargoCompanyMessages.Validation.nullCargoCompanyName)
	@Length(
			min=CargoCompanyConstants.minLengthName,
			max=CargoCompanyConstants.maxLengthName,
			message = CargoCompanyMessages.Validation.lengthCargoCompanyName)
	private String name;
}
