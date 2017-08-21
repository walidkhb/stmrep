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

import com.stm.data.entity.Driver;
import com.stm.data.entity.Driver;
import com.stm.data.rep.DriverRepository;
@Service
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class DriverServiceImpl implements DriverService {

	private final Log log = LogFactory.getLog(DriverServiceImpl.class);
	private DriverRepository driverRepository;

	@Autowired
	public DriverServiceImpl(DriverRepository driverRepository) {

		this.setDriverRepository(driverRepository);
	}

	public DriverRepository getDriverRepository() {
		return driverRepository;
	}

	public void setDriverRepository(DriverRepository driverRepository) {
		this.driverRepository = driverRepository;
	}

	@Override
	public List<Driver> getAll() {
		driverRepository.findAll();
		return driverRepository.findAll();
	}

	@Override
	public Driver addDriver(Driver driver) {
		// TODO Auto-generated method driver
		return driverRepository.save(driver);
	}

	@Override
	public Driver findOne(Long driverId) {
		// TODO Auto-generated method stub
		return driverRepository.findOne(driverId);
	}



	@Override
	public Driver getDriverById(Long id) {
		// TODO Auto-generated method stub
		
		return driverRepository.findOne(id);
	}

	@Override
	public void deleteDriver(Long id) {
		driverRepository.delete(id);		
	}

	@Override
	public Page<Driver> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return driverRepository.findAll(pageable);
	}

	@Override
	public Iterable<Driver> listAlldrivers() {
		// TODO Auto-generated method stub
		 return driverRepository.findAll();
	}

}
