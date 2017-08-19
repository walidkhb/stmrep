package com.stm.service;

import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.stm.data.entity.Company;
import com.stm.data.rep.CompanyRepository;
@Service
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class CompanyServiceImpl implements CompanyService {

	private final Log log = LogFactory.getLog(UserServiceImpl.class);
	private CompanyRepository companyRepository;

	@Autowired
	public CompanyServiceImpl(CompanyRepository companyRepository) {

		this.setCompanyRepository(companyRepository);
	}

	public CompanyRepository getCompanyRepository() {
		return companyRepository;
	}

	public void setCompanyRepository(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	@Override
	public List<Company> getAll() {
		companyRepository.findAll();
		return companyRepository.findAll();
	}

	@Override
	public Company addCompany(Company company) {
		// TODO Auto-generated method company
		return companyRepository.save(company);
	}

	@Override
	public Company findOne(Long companyId) {
		// TODO Auto-generated method stub
		return companyRepository.findOne(companyId);
	}
}
