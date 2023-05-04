package com.tunahan.market.controller.category;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tunahan.market.business.abstracts.category.CargoCompanyService;
import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.dtos.requests.category.cargoCompany.CreateCargoCompanyRequest;
import com.tunahan.market.dtos.responses.category.cargoCompany.CreateCargoCompanyResponse;
import com.tunahan.market.dtos.responses.category.cargoCompany.GetAllCargoCompanyReponse;
import com.tunahan.market.dtos.responses.category.cargoCompany.GetCargoCompanyResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/cargoCompanies/")
@AllArgsConstructor
public class CargoCompanyController {

	private final CargoCompanyService companyService;
	
	@GetMapping("getAll")
	public DataResult<List<GetAllCargoCompanyReponse>> getAll(){
		return companyService.getAll();
	}
	
	@GetMapping("getById/{id}")
	public DataResult<GetCargoCompanyResponse> getById(@PathVariable long id) {
		return companyService.getById(id);
	}
	
	@GetMapping("getByName")
	public DataResult<GetCargoCompanyResponse> getByName(@RequestParam String name) {
		return companyService.getByName(name);
	}
	
	@PostMapping("add")
	public DataResult<CreateCargoCompanyResponse> add(@Valid @RequestBody CreateCargoCompanyRequest request) {
		return companyService.add(request);
	}
}
