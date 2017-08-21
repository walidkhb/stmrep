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

import com.stm.data.entity.Warehouse;
import com.stm.data.entity.Warehouse;
import com.stm.data.rep.WarehouseRepository;
@Service
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class WarehouseServiceImpl implements WarehouseService {

	private final Log log = LogFactory.getLog(WarehouseServiceImpl.class);
	private WarehouseRepository warehouseRepository;

	@Autowired
	public WarehouseServiceImpl(WarehouseRepository warehouseRepository) {

		this.setWarehouseRepository(warehouseRepository);
	}

	public WarehouseRepository getWarehouseRepository() {
		return warehouseRepository;
	}

	public void setWarehouseRepository(WarehouseRepository warehouseRepository) {
		this.warehouseRepository = warehouseRepository;
	}

	@Override
	public List<Warehouse> getAll() {
		warehouseRepository.findAll();
		return warehouseRepository.findAll();
	}

	@Override
	public Warehouse addWarehouse(Warehouse warehouse) {
		// TODO Auto-generated method warehouse
		return warehouseRepository.save(warehouse);
	}

	@Override
	public Warehouse findOne(Long warehouseId) {
		// TODO Auto-generated method stub
		return warehouseRepository.findOne(warehouseId);
	}



	@Override
	public Warehouse getWarehouseById(Long id) {
		// TODO Auto-generated method stub
		
		return warehouseRepository.findOne(id);
	}

	@Override
	public void deleteWarehouse(Long id) {
		warehouseRepository.delete(id);		
	}

	@Override
	public Page<Warehouse> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return warehouseRepository.findAll(pageable);
	}

	@Override
	public Iterable<Warehouse> listAllwarehouses() {
		// TODO Auto-generated method stub
		 return warehouseRepository.findAll();
	}

}
