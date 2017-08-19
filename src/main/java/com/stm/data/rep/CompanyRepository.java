package com.stm.data.rep;

import org.springframework.data.jpa.repository.JpaRepository;



import com.stm.data.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
