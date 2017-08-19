package com.stm.form;



import java.util.HashSet;
import java.util.*;

import com.stm.data.entity.Company;
import com.stm.data.entity.PriceList;

public class CompanyForm {
	private long id;
	private String name;
	private String unit;
	private String description;
	private Set<PriceList> priceLists = new HashSet<PriceList>(0);
private List<Company> companyList;
private Company tempC;
	
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}


	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<PriceList> getPriceLists() {
		return this.priceLists;
	}

	public void setPriceLists(Set<PriceList> priceLists) {
		this.priceLists = priceLists;
	}

	public List<Company> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<Company> companyList) {
		this.companyList = companyList;
	}

	public Company getTempC() {
		return tempC;
	}

	public void setTempC(Company tempC) {
		this.tempC = tempC;
	}

}


