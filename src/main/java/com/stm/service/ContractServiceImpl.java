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

import com.stm.data.entity.Contract;
import com.stm.data.entity.Contract;
import com.stm.data.rep.ContractRepository;
@Service
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class ContractServiceImpl implements ContractService {

	private final Log log = LogFactory.getLog(ContractServiceImpl.class);
	private ContractRepository contractRepository;

	@Autowired
	public ContractServiceImpl(ContractRepository contractRepository) {

		this.setContractRepository(contractRepository);
	}

	public ContractRepository getContractRepository() {
		return contractRepository;
	}

	public void setContractRepository(ContractRepository contractRepository) {
		this.contractRepository = contractRepository;
	}

	@Override
	public List<Contract> getAll() {
		contractRepository.findAll();
		return contractRepository.findAll();
	}

	@Override
	public Contract addContract(Contract contract) {
		// TODO Auto-generated method contract
		return contractRepository.save(contract);
	}

	@Override
	public Contract findOne(Long contractId) {
		// TODO Auto-generated method stub
		return contractRepository.findOne(contractId);
	}



	@Override
	public Contract getContractById(Long id) {
		// TODO Auto-generated method stub
		
		return contractRepository.findOne(id);
	}

	@Override
	public void deleteContract(Long id) {
		contractRepository.delete(id);		
	}

	@Override
	public Page<Contract> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return contractRepository.findAll(pageable);
	}

	@Override
	public Iterable<Contract> listAllContracts() {
		// TODO Auto-generated method stub
		 return contractRepository.findAll();
	}

}
