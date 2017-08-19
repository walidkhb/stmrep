package com.stm.form;



import com.stm.data.entity.Company;

public class DriverForm {private long id;
private Company company;
private String name;
private String mobile;
private String nationalId;



public long getId() {
	return this.id;
}

public void setId(long id) {
	this.id = id;
}


public Company getCompany() {
	return this.company;
}

public void setCompany(Company company) {
	this.company = company;
}


public String getName() {
	return this.name;
}

public void setName(String name) {
	this.name = name;
}


public String getMobile() {
	return this.mobile;
}

public void setMobile(String mobile) {
	this.mobile = mobile;
}


public String getNationalId() {
	return this.nationalId;
}

public void setNationalId(String nationalId) {
	this.nationalId = nationalId;
}

}



