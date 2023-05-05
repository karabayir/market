package com.tunahan.market.business.concretes.cargo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tunahan.market.business.abstracts.cargo.CargoCompanyService;
import com.tunahan.market.core.utilities.mapping.ModelMapperService;
import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.core.utilities.result.Result;
import com.tunahan.market.core.utilities.result.SuccessDataResult;
import com.tunahan.market.core.utilities.result.SuccessResult;
import com.tunahan.market.dtos.requests.cargo.CreateCargoCompanyRequest;
import com.tunahan.market.dtos.requests.cargo.UpdateCargoCompanyRequest;
import com.tunahan.market.dtos.responses.cargo.CreateCargoCompanyResponse;
import com.tunahan.market.dtos.responses.cargo.GetAllCargoCompanyReponse;
import com.tunahan.market.dtos.responses.cargo.GetCargoCompanyResponse;
import com.tunahan.market.dtos.responses.cargo.UpdateCargoCompanyResponse;
import com.tunahan.market.entities.category.CargoCompany;
import com.tunahan.market.repository.cargo.CargoCompanyRepository;
import com.tunahan.market.rules.category.CargoCompanyRules;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CargoCompanyManager implements CargoCompanyService{
	
	private final CargoCompanyRepository cargoRepository;
	private final ModelMapperService mapperService;
	private final CargoCompanyRules rules;
	
	@Override
	public DataResult<List<GetAllCargoCompanyReponse>> getAll() {
		List<GetAllCargoCompanyReponse> result = cargoRepository.findAll()
				.stream()
				.map(c -> mapperService.forResponse().map(c, GetAllCargoCompanyReponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllCargoCompanyReponse>>(result, "getAll");
	}

	@Override
	public DataResult<GetCargoCompanyResponse> getById(long id) {
		rules.checkIfCargoCompanyExists(id);
		CargoCompany company = cargoRepository.findById(id).orElseThrow();
		GetCargoCompanyResponse result= mapperService.forResponse().map(company, GetCargoCompanyResponse.class);
		return new SuccessDataResult<GetCargoCompanyResponse>(result, "getById");
	}

	@Override
	public DataResult<GetCargoCompanyResponse> getByName(String name) {
		rules.checkIfCargoCompanyExists(name);
		CargoCompany company = cargoRepository.findByName(name).orElseThrow();
		GetCargoCompanyResponse result= mapperService.forResponse().map(company, GetCargoCompanyResponse.class);
		return new SuccessDataResult<GetCargoCompanyResponse>(result, "getByName");
	}

	@Override
	public DataResult<CreateCargoCompanyResponse>  add(CreateCargoCompanyRequest request) {
		rules.checkIfCargoCompanyNameExists(request.getName());
		CargoCompany company = mapperService.forRequest().map(request, CargoCompany.class);
		cargoRepository.save(company);
		CreateCargoCompanyResponse result= mapperService.forResponse().map(company, CreateCargoCompanyResponse.class);
		return new SuccessDataResult<CreateCargoCompanyResponse>(result, "add");
	}

	@Override
	public DataResult<UpdateCargoCompanyResponse> update(UpdateCargoCompanyRequest request) {
		rules.checkIfCargoCompanyExists(request.getId());
		CargoCompany company = mapperService.forRequest().map(request, CargoCompany.class);
		cargoRepository.save(company);
		UpdateCargoCompanyResponse result= mapperService.forResponse().map(company, UpdateCargoCompanyResponse.class);
		return new SuccessDataResult<UpdateCargoCompanyResponse>(result, "update");
	}

	@Override
	public Result delete(long id) {
		rules.checkIfCargoCompanyExists(id);
		cargoRepository.deleteById(id);
		return new SuccessResult("delete");
	}

	@Override
	public DataResult<Page<CargoCompany>> getAllPageable(int number, int size) {
		Pageable pageable = PageRequest.of(number, size);
		Page<CargoCompany> result= cargoRepository.findAll(pageable);
		return new SuccessDataResult<Page<CargoCompany>>(result, "getAllPageable");
	}
	

}
