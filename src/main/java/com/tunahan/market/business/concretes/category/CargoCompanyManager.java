package com.tunahan.market.business.concretes.category;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tunahan.market.business.abstracts.category.CargoCompanyService;
import com.tunahan.market.core.utilities.mapping.ModelMapperService;
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
	public List<GetAllCargoCompanyReponse> getAll() {
		return companyRepository.findAll()
				.stream()
				.map(c -> mapperService.forResponse().map(c, GetAllCargoCompanyReponse.class))
				.collect(Collectors.toList());
	}

	@Override
	public GetCargoCompanyResponse getById(long id) {
		rules.checkIfCargoCompanyExists(id);
		CargoCompany company = companyRepository.findById(id).orElseThrow();
		return mapperService.forResponse().map(company, GetCargoCompanyResponse.class);
	}

	@Override
	public GetCargoCompanyResponse getByName(String name) {
		rules.checkIfCargoCompanyExists(name);
		CargoCompany company = companyRepository.findByName(name).orElseThrow();
		return mapperService.forResponse().map(company, GetCargoCompanyResponse.class);
	}

	@Override
	public CreateCargoCompanyResponse add(CreateCargoCompanyRequest createRequest) {
		CargoCompany company = mapperService.forRequest().map(createRequest, CargoCompany.class);
		companyRepository.save(company);
		return mapperService.forResponse().map(company, CreateCargoCompanyResponse.class);
	}

}
