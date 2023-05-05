package com.tunahan.market.controller.cargo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tunahan.market.business.abstracts.cargo.CargoCompanyService;
import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.core.utilities.result.Result;
import com.tunahan.market.dtos.requests.cargo.CreateCargoCompanyRequest;
import com.tunahan.market.dtos.requests.cargo.UpdateCargoCompanyRequest;
import com.tunahan.market.dtos.responses.cargo.CreateCargoCompanyResponse;
import com.tunahan.market.dtos.responses.cargo.GetAllCargoCompanyReponse;
import com.tunahan.market.dtos.responses.cargo.GetCargoCompanyResponse;
import com.tunahan.market.dtos.responses.cargo.UpdateCargoCompanyResponse;
import com.tunahan.market.entities.category.CargoCompany;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/cargoCompanies/")
@AllArgsConstructor
public class CargoCompanyController {

	private final CargoCompanyService cargoService;
	
	@GetMapping("getAll")
	public DataResult<List<GetAllCargoCompanyReponse>> getAll(){
		return cargoService.getAll();
	}
	
	@GetMapping("getById/{id}")
	public DataResult<GetCargoCompanyResponse> getById(@PathVariable long id) {
		return cargoService.getById(id);
	}
	
	@GetMapping("getByName")
	public DataResult<GetCargoCompanyResponse> getByName(@RequestParam String name) {
		return cargoService.getByName(name);
	}
	
	@PostMapping("add")
	public DataResult<CreateCargoCompanyResponse> add(@Valid @RequestBody CreateCargoCompanyRequest request) {
		return cargoService.add(request);
	}
	
	@PutMapping("update")
	public DataResult<UpdateCargoCompanyResponse> update(@Valid @RequestBody UpdateCargoCompanyRequest request){
		return cargoService.update(request);
	}
	
	@DeleteMapping("delete/{id}")
	public Result delete(@PathVariable long id) {
		return cargoService.delete(id);
	}
	
	@GetMapping("getAllPageable")
	public DataResult<Page<CargoCompany>> getAllPageable(@RequestParam int number, @RequestParam int size){
		return cargoService.getAllPageable(number, size);
	}
}
