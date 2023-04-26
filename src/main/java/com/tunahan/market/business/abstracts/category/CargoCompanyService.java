package com.tunahan.market.business.abstracts.category;

import java.util.List;

import com.tunahan.market.dtos.requests.category.cargoCompany.CreateCargoCompanyRequest;
import com.tunahan.market.dtos.responses.category.cargoCompany.CreateCargoCompanyResponse;
import com.tunahan.market.dtos.responses.category.cargoCompany.GetAllCargoCompanyReponse;
import com.tunahan.market.dtos.responses.category.cargoCompany.GetCargoCompanyResponse;

public interface CargoCompanyService {

	List<GetAllCargoCompanyReponse> getAll();
	GetCargoCompanyResponse getById(long id);
	GetCargoCompanyResponse getByName(String name);
	CreateCargoCompanyResponse add(CreateCargoCompanyRequest createRequest);
}
