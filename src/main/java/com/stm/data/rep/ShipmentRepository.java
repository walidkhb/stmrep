package com.stm.data.rep;

import org.springframework.data.jpa.repository.JpaRepository;


import com.stm.data.entity.Shipment;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {

}
