package com.tunahan.market.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunahan.market.entities.order.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
