package com.tunahan.market.business.abstracts.cargo;

import java.util.List;

import org.springframework.data.domain.Page;

import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.core.utilities.result.Result;
import com.tunahan.market.dtos.requests.cargo.CreateCargoCompanyRequest;
import com.tunahan.market.dtos.requests.cargo.UpdateCargoCompanyRequest;
import com.tunahan.market.dtos.responses.cargo.CreateCargoCompanyResponse;
import com.tunahan.market.dtos.responses.cargo.GetAllCargoCompanyReponse;
import com.tunahan.market.dtos.responses.cargo.GetCargoCompanyResponse;
import com.tunahan.market.dtos.responses.cargo.UpdateCargoCompanyResponse;
import com.tunahan.market.entities.category.CargoCompany;

public interface CargoCompanyService {

	DataResult<List<GetAllCargoCompanyReponse>> getAll();
	DataResult<GetCargoCompanyResponse> getById(long id);
	DataResult<GetCargoCompanyResponse> getByName(String name);
	DataResult<CreateCargoCompanyResponse> add(CreateCargoCompanyRequest request);
	DataResult<UpdateCargoCompanyResponse> update(UpdateCargoCompanyRequest request);
	DataResult<Page<CargoCompany>> getAllPageable(int number, int size);
	Result delete(long id);
}
