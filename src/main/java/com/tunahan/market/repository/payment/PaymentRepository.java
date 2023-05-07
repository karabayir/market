package com.tunahan.market.repository.payment;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunahan.market.entities.payment.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

	Optional<Payment> findByConfirmNumber(String confirmNumber);
	boolean existsByConfirmNumber(String confirmNumber);
}
