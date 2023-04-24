package com.tunahan.market.repository.postOrder;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunahan.market.entities.postOrder.Shipment;

public interface ShipmentRepository extends JpaRepository<Shipment, Long>{

}
