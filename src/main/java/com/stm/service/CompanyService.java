package com.stm.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.stm.data.entity.Company;


public interface CompanyService {
	
	
public abstract List<Company> getAll();
public abstract Company addCompany(Company company);
public abstract Company findOne(Long companyId);
Iterable<Company> listAllCompanies();

   Company getCompanyById(Long id);

  

   void deleteCompany(Long id);

   Page<Company> findAll(Pageable pageable);
   
   
   
}
