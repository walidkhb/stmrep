package com.stm.data.rep;

import org.springframework.data.jpa.repository.JpaRepository;


import com.stm.data.entity.PriceList;

public interface PriceListRepository extends JpaRepository<PriceList, Long> {

}
