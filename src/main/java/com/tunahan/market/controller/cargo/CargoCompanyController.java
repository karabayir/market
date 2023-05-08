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
import com.tunahan.market.core.messages.cargo.CargoCompanyMessages;
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
@RequestMapping(path = CargoCompanyMessages.Controller.requestMapping)
@AllArgsConstructor
public class CargoCompanyController {

	private final CargoCompanyService cargoService;
	
	@GetMapping(path =CargoCompanyMessages.Controller.getAll)
	public DataResult<List<GetAllCargoCompanyReponse>> getAll(){
		return cargoService.getAll();
	}
	
	@GetMapping(path = CargoCompanyMessages.Controller.getById)
	public DataResult<GetCargoCompanyResponse> getById(@PathVariable long id) {
		return cargoService.getById(id);
	}
	
	@GetMapping(path = CargoCompanyMessages.Controller.getByName)
	public DataResult<GetCargoCompanyResponse> getByName(@RequestParam String name) {
		return cargoService.getByName(name);
	}
	
	@PostMapping(path = CargoCompanyMessages.Controller.add)
	public DataResult<CreateCargoCompanyResponse> add(@Valid @RequestBody CreateCargoCompanyRequest request) {
		return cargoService.add(request);
	}
	
	@PutMapping(path = CargoCompanyMessages.Controller.update)
	public DataResult<UpdateCargoCompanyResponse> update(@Valid @RequestBody UpdateCargoCompanyRequest request){
		return cargoService.update(request);
	}
	
	@DeleteMapping(path = CargoCompanyMessages.Controller.deleteById)
	public Result delete(@PathVariable long id) {
		return cargoService.delete(id);
	}
	
	@GetMapping(path = CargoCompanyMessages.Controller.pageable)
	public DataResult<Page<CargoCompany>> getAllPageable(@RequestParam int number, @RequestParam int size){
		return cargoService.getAllPageable(number, size);
	}
}
