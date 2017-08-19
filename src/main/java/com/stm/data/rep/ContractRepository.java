package com.stm.data.rep;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stm.data.entity.Contract;



public interface ContractRepository extends JpaRepository<Contract, Long> {

}
