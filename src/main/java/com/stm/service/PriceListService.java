package com.stm.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.stm.data.entity.PriceList;



public interface PriceListService {
public abstract List<PriceList> getAll();
public abstract PriceList addPriceList(PriceList priceList);
public abstract PriceList findOne(Long priceListId);
Iterable<PriceList> listAllPriceLists();

   PriceList getPriceListById(Long id);

  

   void deletePriceList(Long id);

   Page<PriceList> findAll(Pageable pageable);
}
