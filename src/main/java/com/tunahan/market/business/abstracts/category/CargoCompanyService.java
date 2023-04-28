package com.tunahan.market.business.abstracts.category;

import java.util.List;

import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.dtos.requests.category.cargoCompany.CreateCargoCompanyRequest;
import com.tunahan.market.dtos.responses.category.cargoCompany.CreateCargoCompanyResponse;
import com.tunahan.market.dtos.responses.category.cargoCompany.GetAllCargoCompanyReponse;
import com.tunahan.market.dtos.responses.category.cargoCompany.GetCargoCompanyResponse;

public interface CargoCompanyService {

	DataResult<List<GetAllCargoCompanyReponse>> getAll();
	DataResult<GetCargoCompanyResponse> getById(long id);
	DataResult<GetCargoCompanyResponse> getByName(String name);
	DataResult<CreateCargoCompanyResponse> add(CreateCargoCompanyRequest createRequest);
}
