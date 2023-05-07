package com.tunahan.market.business.abstracts.payment;

import java.util.List;

import org.springframework.data.domain.Page;

import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.core.utilities.result.Result;
import com.tunahan.market.dtos.requests.payment.CreatePaymentRequest;
import com.tunahan.market.dtos.requests.payment.UpdatePaymentRequest;
import com.tunahan.market.dtos.responses.payment.CreatePaymentResponse;
import com.tunahan.market.dtos.responses.payment.GetAllPaymentResponse;
import com.tunahan.market.dtos.responses.payment.GetPaymentResponse;
import com.tunahan.market.dtos.responses.payment.UpdatePaymentResponse;
import com.tunahan.market.entities.payment.Payment;

public interface PaymentService {

	DataResult<List<GetAllPaymentResponse>> getAll();
	DataResult<GetPaymentResponse> getById(long id);
	DataResult<GetPaymentResponse> getByConfirmNumber(String number);
	DataResult<CreatePaymentResponse> add(CreatePaymentRequest request);
	DataResult<UpdatePaymentResponse> update(UpdatePaymentRequest request);
	DataResult<Page<Payment>> getAllPageable(int number, int size);
	Result delete(long id);
	
}
