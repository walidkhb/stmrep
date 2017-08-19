package com.stm.data.rep;

import org.springframework.data.jpa.repository.JpaRepository;


import com.stm.data.entity.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long> {

}
