package com.tunahan.market.repository.payment;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunahan.market.entities.payment.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
