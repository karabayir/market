package com.tunahan.market.rules.payment;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.tunahan.market.core.exceptions.BusinessException;
import com.tunahan.market.core.messages.payment.PaymentMessages;
import com.tunahan.market.entities.payment.Payment;
import com.tunahan.market.entities.payment.PaymentStatus;
import com.tunahan.market.repository.payment.PaymentRepository;
import com.tunahan.market.rules.BaseRules;

@Service
public class PaymentRules extends BaseRules{

	private final PaymentRepository paymentRepository;

	public PaymentRules(MessageSource messageSource, PaymentRepository paymentRepository) {
		super(messageSource);
		this.paymentRepository = paymentRepository;
	}
	
	public void checkIfPaymentExists(long id) {
		if(!paymentRepository.existsById(id))
			new BusinessException(id+messageSource.getMessage(PaymentMessages.Business.notExists, null, LocaleContextHolder.getLocale()));
	}
	
	public void checkIfPaymentExists(String confirmNumber) {
		if(!paymentRepository.existsByConfirmNumber(confirmNumber))
			new BusinessException(confirmNumber+messageSource.getMessage(PaymentMessages.Business.notExists, null, LocaleContextHolder.getLocale()));
	}
	
	public void checkIfInsufficientBalance(double orderPrice, double paymentPrice,Payment payment) {
		if(paymentPrice<orderPrice)
			payment.setPaymentStatus(PaymentStatus.REJECTED);
		if(paymentPrice>=orderPrice)
			payment.setPaymentStatus(PaymentStatus.CONFIRMED);
	}

}
