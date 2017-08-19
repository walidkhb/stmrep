package com.stm.service;

import java.util.List;


import com.stm.data.entity.Company;

public interface CompanyService {
public abstract List<Company> getAll();
public abstract Company addCompany(Company company);
public abstract Company findOne(Long companyId);

}
