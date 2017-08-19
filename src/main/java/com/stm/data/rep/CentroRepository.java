package com.stm.data.rep;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.stm.data.entity.Centro;

/**
 * Created by admin on 05/04/2017.
 */
public interface CentroRepository extends CrudRepository<Centro, Integer> {
    
    Page<Centro> findAll(Pageable pageable);

}
