package com.tunahan.market.controller.payment;

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

import com.tunahan.market.business.abstracts.payment.PaymentService;
import com.tunahan.market.core.messages.payment.PaymentMessages;
import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.core.utilities.result.Result;
import com.tunahan.market.dtos.requests.payment.CreatePaymentRequest;
import com.tunahan.market.dtos.requests.payment.UpdatePaymentRequest;
import com.tunahan.market.dtos.responses.payment.CreatePaymentResponse;
import com.tunahan.market.dtos.responses.payment.GetAllPaymentResponse;
import com.tunahan.market.dtos.responses.payment.GetPaymentResponse;
import com.tunahan.market.dtos.responses.payment.UpdatePaymentResponse;
import com.tunahan.market.entities.payment.Payment;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = PaymentMessages.Controller.requestMapping)
@AllArgsConstructor
public class PaymentController {

	private final PaymentService paymentService;
	
	@GetMapping(path = PaymentMessages.Controller.getAll)
	public DataResult<List<GetAllPaymentResponse>> getAll(){
		return paymentService.getAll();
	}
	
	@GetMapping(path = PaymentMessages.Controller.getById)
	public DataResult<GetPaymentResponse> getById(@PathVariable long id){
		return paymentService.getById(id);
	}
	
	@GetMapping(path = PaymentMessages.Controller.getByConfirmNumber)
	public DataResult<GetPaymentResponse> getByConfirmNumber(@RequestParam String number){
		return paymentService.getByConfirmNumber(number);
	}
	
	@PostMapping(path = PaymentMessages.Controller.add)
	public DataResult<CreatePaymentResponse> add(@Valid @RequestBody CreatePaymentRequest request){
		return paymentService.add(request);
	}
	
	@PutMapping(path = PaymentMessages.Controller.update)
	public DataResult<UpdatePaymentResponse> update(@Valid @RequestBody UpdatePaymentRequest request){
		return paymentService.update(request);
	}
	
	@GetMapping(path = PaymentMessages.Controller.pageable)
	public DataResult<Page<Payment>> getAllPageable(@RequestParam int number, @RequestParam int size){
		return paymentService.getAllPageable(number, size);
	}
	
	@DeleteMapping(path = PaymentMessages.Controller.deleteById)
	public Result delete(@PathVariable long id) {
		return paymentService.delete(id);
	}
}
