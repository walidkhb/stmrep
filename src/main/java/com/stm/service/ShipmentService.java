package com.stm.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.stm.data.entity.Shipment;

public interface ShipmentService {

	void saveShipment(Shipment shipment);

	void updateShipment(Shipment shipment);

	void deleteShipmentById(Long id);

	void deleteAllShipments();

	List<Shipment> findAllShipments();
	 Iterable<Shipment> listAllShipments();

	    Shipment getShipmentById(Long id);

	   

	    void deleteShipment(Long id);

	    Page<Shipment> findAll(Pageable pageable);
}
