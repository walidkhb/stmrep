package com.stm.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.stm.data.entity.Driver;

public interface DriverService {
	public abstract List<Driver> getAll();
	public abstract Driver addDriver(Driver driver);
	public abstract Driver findOne(Long driverId);
	Iterable<Driver> listAlldrivers();

	   Driver getDriverById(Long id);

	  

	   void deleteDriver(Long id);

	   Page<Driver> findAll(Pageable pageable);
	   
}
