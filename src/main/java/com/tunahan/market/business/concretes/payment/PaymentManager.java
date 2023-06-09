package com.tunahan.market.business.concretes.payment;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tunahan.market.business.abstracts.order.OrderService;
import com.tunahan.market.business.abstracts.payment.PaymentService;
import com.tunahan.market.core.messages.payment.PaymentMessages;
import com.tunahan.market.core.utilities.mapping.ModelMapperService;
import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.core.utilities.result.Result;
import com.tunahan.market.core.utilities.result.SuccessDataResult;
import com.tunahan.market.core.utilities.result.SuccessResult;
import com.tunahan.market.dtos.requests.payment.CreatePaymentRequest;
import com.tunahan.market.dtos.requests.payment.UpdatePaymentRequest;
import com.tunahan.market.dtos.responses.payment.CreatePaymentResponse;
import com.tunahan.market.dtos.responses.payment.GetAllPaymentResponse;
import com.tunahan.market.dtos.responses.payment.GetPaymentResponse;
import com.tunahan.market.dtos.responses.payment.UpdatePaymentResponse;
import com.tunahan.market.entities.order.Order;
import com.tunahan.market.entities.payment.Payment;
import com.tunahan.market.repository.payment.PaymentRepository;
import com.tunahan.market.rules.order.OrderRules;
import com.tunahan.market.rules.payment.PaymentRules;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PaymentManager implements PaymentService{
	
	private PaymentRepository paymentRepository;
	private ModelMapperService mapperService;
	private PaymentRules rules;
	private OrderRules orderRules;
	private OrderService orderService;

	@Override
	public DataResult<List<GetAllPaymentResponse>> getAll() {
		List<GetAllPaymentResponse> result = paymentRepository.findAll()
				.stream()
				.map(p -> mapperService.forResponse().map(p, GetAllPaymentResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllPaymentResponse>>(result,PaymentMessages.Result.getAllPayment);
	}

	@Override
	public DataResult<GetPaymentResponse> getById(long id) {
		rules.checkIfPaymentExists(id);
		Payment payment = paymentRepository.findById(id).orElseThrow();
		GetPaymentResponse result = mapperService.forResponse().map(payment, GetPaymentResponse.class);
		return new SuccessDataResult<GetPaymentResponse>(result,PaymentMessages.Result.getPaymentById);
	}
	
	@Override
	public DataResult<GetPaymentResponse> getByConfirmNumber(String number) {
		rules.checkIfPaymentExists(number);
		Payment payment = paymentRepository.findByConfirmNumber(number).orElseThrow();
		GetPaymentResponse result = mapperService.forResponse().map(payment, GetPaymentResponse.class);
		return new SuccessDataResult<GetPaymentResponse>(result,PaymentMessages.Result.getPaymentByConfirmNumber);
	}

	@Override
	public DataResult<CreatePaymentResponse> add(CreatePaymentRequest request) {
		orderRules.checkIfOrderExists(request.getOrderId());
		Payment payment = mapperService.forRequest().map(request, Payment.class);
		payment.setId(0);
		Order order = mapperService.forResponse().map(orderService.getById(request.getOrderId()).getData(), Order.class);
		rules.checkIfInsufficientBalance(order.getTotalPrice(),request.getTotalPrice(),payment);
		paymentRepository.save(payment);
		CreatePaymentResponse result = mapperService.forResponse().map(payment, CreatePaymentResponse.class);
		return new SuccessDataResult<CreatePaymentResponse>(result,PaymentMessages.Result.addPayment);
	}

	@Override
	public DataResult<UpdatePaymentResponse> update(UpdatePaymentRequest request) {
		rules.checkIfPaymentExists(request.getId());
		orderRules.checkIfOrderExists(request.getOrderId());
		Payment payment = mapperService.forRequest().map(request, Payment.class);
		paymentRepository.save(payment);
		UpdatePaymentResponse result = mapperService.forResponse().map(payment, UpdatePaymentResponse.class);
		return new SuccessDataResult<UpdatePaymentResponse>(result,PaymentMessages.Result.updatePayment);
	}

	@Override
	public DataResult<Page<Payment>> getAllPageable(int number, int size) {
		Pageable pageable = PageRequest.of(number, size);
		Page<Payment> result = paymentRepository.findAll(pageable);
		return new SuccessDataResult<Page<Payment>>(result,PaymentMessages.Result.getAllPaymentPageable);
	}

	@Override
	public Result delete(long id) {
		rules.checkIfPaymentExists(id);
		paymentRepository.deleteById(id);
		return new SuccessResult(PaymentMessages.Result.deletePayment);
	}

}
