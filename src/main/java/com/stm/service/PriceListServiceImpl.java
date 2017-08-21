package com.stm.service;

import java.util.List;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.stm.data.entity.PriceList;

import com.stm.data.rep.PriceListRepository;
@Service
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class PriceListServiceImpl implements PriceListService {

	private final Log log = LogFactory.getLog(PriceListServiceImpl.class);
	private PriceListRepository priceListRepository;

	@Autowired
	public PriceListServiceImpl(PriceListRepository priceListRepository) {

		this.setPriceListRepository(priceListRepository);
	}

	public PriceListRepository getPriceListRepository() {
		return priceListRepository;
	}

	public void setPriceListRepository(PriceListRepository priceListRepository) {
		this.priceListRepository = priceListRepository;
	}

	@Override
	public List<PriceList> getAll() {
		priceListRepository.findAll();
		return priceListRepository.findAll();
	}

	@Override
	public PriceList addPriceList(PriceList priceList) {
		// TODO Auto-generated method priceList
		return priceListRepository.save(priceList);
	}

	@Override
	public PriceList findOne(Long priceListId) {
		// TODO Auto-generated method stub
		return priceListRepository.findOne(priceListId);
	}



	@Override
	public PriceList getPriceListById(Long id) {
		// TODO Auto-generated method stub
		
		return priceListRepository.findOne(id);
	}

	@Override
	public void deletePriceList(Long id) {
		priceListRepository.delete(id);		
	}

	@Override
	public Page<PriceList> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return priceListRepository.findAll(pageable);
	}

	@Override
	public Iterable<PriceList> listAllPriceLists() {
		// TODO Auto-generated method stub
		 return priceListRepository.findAll();
	}

}
