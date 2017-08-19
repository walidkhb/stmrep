package com.stm.data.rep;

import org.springframework.data.jpa.repository.JpaRepository;


import com.stm.data.entity.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

}
