package com.stm.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.stm.data.entity.Warehouse;

public interface WarehouseService {
	public abstract List<Warehouse> getAll();
	public abstract Warehouse addWarehouse(Warehouse warehouse);
	public abstract Warehouse findOne(Long warehouseId);
	Iterable<Warehouse> listAllwarehouses();

	   Warehouse getWarehouseById(Long id);

	  

	   void deleteWarehouse(Long id);

	   Page<Warehouse> findAll(Pageable pageable);
	   
}
