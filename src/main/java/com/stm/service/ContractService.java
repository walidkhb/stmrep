package com.stm.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.stm.data.entity.Contract;

public interface ContractService {
	public abstract List<Contract> getAll();
	public abstract Contract addContract(Contract contract);
	public abstract Contract findOne(Long contractId);
	Iterable<Contract> listAllContracts();

	   Contract getContractById(Long id);

	  

	   void deleteContract(Long id);

	   Page<Contract> findAll(Pageable pageable);
	   
}
