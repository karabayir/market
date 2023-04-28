package com.tunahan.market.business.concretes.category;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tunahan.market.business.abstracts.category.CargoCompanyService;
import com.tunahan.market.core.utilities.mapping.ModelMapperService;
import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.core.utilities.result.SuccessDataResult;
import com.tunahan.market.dtos.requests.category.cargoCompany.CreateCargoCompanyRequest;
import com.tunahan.market.dtos.responses.category.cargoCompany.CreateCargoCompanyResponse;
import com.tunahan.market.dtos.responses.category.cargoCompany.GetAllCargoCompanyReponse;
import com.tunahan.market.dtos.responses.category.cargoCompany.GetCargoCompanyResponse;
import com.tunahan.market.entities.category.CargoCompany;
import com.tunahan.market.repository.category.CargoCompanyRepository;
import com.tunahan.market.rules.category.CargoCompanyRules;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CargoCompanyManager implements CargoCompanyService{
	
	private final CargoCompanyRepository companyRepository;
	private final ModelMapperService mapperService;
	private final CargoCompanyRules rules;
	
	@Override
	public DataResult<List<GetAllCargoCompanyReponse>> getAll() {
		List<GetAllCargoCompanyReponse> result = companyRepository.findAll()
				.stream()
				.map(c -> mapperService.forResponse().map(c, GetAllCargoCompanyReponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllCargoCompanyReponse>>(result, "getAll");
	}

	@Override
	public DataResult<GetCargoCompanyResponse> getById(long id) {
		rules.checkIfCargoCompanyExists(id);
		CargoCompany company = companyRepository.findById(id).orElseThrow();
		GetCargoCompanyResponse result= mapperService.forResponse().map(company, GetCargoCompanyResponse.class);
		return new SuccessDataResult<GetCargoCompanyResponse>(result, "getById");
	}

	@Override
	public DataResult<GetCargoCompanyResponse> getByName(String name) {
		rules.checkIfCargoCompanyExists(name);
		CargoCompany company = companyRepository.findByName(name).orElseThrow();
		GetCargoCompanyResponse result= mapperService.forResponse().map(company, GetCargoCompanyResponse.class);
		return new SuccessDataResult<GetCargoCompanyResponse>(result, "getByName");
	}

	@Override
	public DataResult<CreateCargoCompanyResponse>  add(CreateCargoCompanyRequest createRequest) {
		rules.checkIfCargoCompanyNameExists(createRequest.getName());
		CargoCompany company = mapperService.forRequest().map(createRequest, CargoCompany.class);
		companyRepository.save(company);
		CreateCargoCompanyResponse result= mapperService.forResponse().map(company, CreateCargoCompanyResponse.class);
		return new SuccessDataResult<CreateCargoCompanyResponse>(result, "add");
	}

}
