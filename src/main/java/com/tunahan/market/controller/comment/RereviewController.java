package com.tunahan.market.controller.comment;

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

import com.tunahan.market.business.abstracts.comment.RereviewService;
import com.tunahan.market.core.messages.comment.RereviewMessages;
import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.core.utilities.result.Result;
import com.tunahan.market.dtos.requests.comment.rereview.CreateRereviewRequest;
import com.tunahan.market.dtos.requests.comment.rereview.UpdateRereviewRequest;
import com.tunahan.market.dtos.responses.comment.rereview.CreateRereviewResponse;
import com.tunahan.market.dtos.responses.comment.rereview.GetAllRereviewResponse;
import com.tunahan.market.dtos.responses.comment.rereview.GetRereviewResponse;
import com.tunahan.market.dtos.responses.comment.rereview.UpdateRereviewResponse;
import com.tunahan.market.entities.comment.Rereview;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = RereviewMessages.Controller.requestMapping)
@AllArgsConstructor
public class RereviewController {

	private final RereviewService rereviewService;
	
	@GetMapping(path = RereviewMessages.Controller.getAll)
	DataResult<List<GetAllRereviewResponse>> getAll(){
		return rereviewService.getAll();
	}
	
	@GetMapping(path = RereviewMessages.Controller.getById)
	DataResult<GetRereviewResponse> getById(@PathVariable long id){
		return rereviewService.getById(id);
	}
	
	@PostMapping(path = RereviewMessages.Controller.add)
	DataResult<CreateRereviewResponse> add(@Valid @RequestBody CreateRereviewRequest request){
		return rereviewService.add(request);
	}
	
	@PutMapping(path = RereviewMessages.Controller.update)
	DataResult<UpdateRereviewResponse> update(@Valid @RequestBody UpdateRereviewRequest request){
		return rereviewService.update(request);
	}
	
	@GetMapping(path = RereviewMessages.Controller.pageable)
	DataResult<Page<Rereview>> getAllPageable(@RequestParam int number, @RequestParam int size){
		return rereviewService.getAllPageable(number, size);
	}
	
	@DeleteMapping(path = RereviewMessages.Controller.deleteById)
	Result delete(@PathVariable long id) {
		return rereviewService.delete(id);
	}
}
