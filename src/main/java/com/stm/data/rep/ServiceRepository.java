package com.stm.data.rep;

import org.springframework.data.jpa.repository.JpaRepository;


import com.stm.data.entity.Service;

public interface ServiceRepository extends JpaRepository<Service, Long> {

}
