package com.stm.service;

import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.stm.data.entity.Shipment;
import com.stm.data.entity.Shipment;
import com.stm.data.rep.ShipmentRepository;
@Service
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class ShipmentServiceImpl implements ShipmentService {

	private final Log log = LogFactory.getLog(ShipmentServiceImpl.class);
	private ShipmentRepository shipmentRepository;

	@Autowired
	public ShipmentServiceImpl(ShipmentRepository shipmentRepository) {

		this.setShipmentRepository(shipmentRepository);
	}

	public ShipmentRepository getShipmentRepository() {
		return shipmentRepository;
	}

	public void setShipmentRepository(ShipmentRepository shipmentRepository) {
		this.shipmentRepository = shipmentRepository;
	}

	

	@Override
	public Shipment getShipmentById(Long id) {
		// TODO Auto-generated method stub
		
		return shipmentRepository.findOne(id);
	}

	@Override
	public void deleteShipment(Long id) {
		shipmentRepository.delete(id);		
	}

	@Override
	public Page<Shipment> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return shipmentRepository.findAll(pageable);
	}

	@Override
	public Iterable<Shipment> listAllShipments() {
		// TODO Auto-generated method stub
		 return shipmentRepository.findAll();
	}

	@Override
	public void saveShipment(Shipment shipment) {
		// TODO Auto-generated method stub
		shipmentRepository.save(shipment);
		
	}

	@Override
	public void updateShipment(Shipment shipment) {
		// TODO Auto-generated method stub
		shipmentRepository.save(shipment);
		
	}

	@Override
	public void deleteShipmentById(Long id) {
		// TODO Auto-generated method stub
		shipmentRepository.delete(id);
		
	}

	@Override
	public void deleteAllShipments() {
		shipmentRepository.deleteAll();
		
	}

	@Override
	public List<Shipment> findAllShipments() {
		// TODO Auto-generated method stub
		return shipmentRepository.findAll();
	}

}
