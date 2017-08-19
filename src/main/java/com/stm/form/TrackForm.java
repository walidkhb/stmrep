package com.stm.form;



import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


import com.stm.data.entity.Contract;
import com.stm.data.entity.PriceList;
import com.stm.data.entity.Shipment;
import com.stm.data.entity.Warehouse;

public class TrackForm {private long id;
private Contract contract;
private Warehouse warehouseByWarehouseTo;
private Warehouse warehouseByWarehouseFrom;
private String description;
private BigDecimal startingPrice;
private Set<Shipment> shipments = new HashSet<Shipment>(0);
private Set<PriceList> priceLists = new HashSet<PriceList>(0);



public long getId() {
	return this.id;
}

public void setId(long id) {
	this.id = id;
}


public Contract getContract() {
	return this.contract;
}

public void setContract(Contract contract) {
	this.contract = contract;
}

public Warehouse getWarehouseByWarehouseTo() {
	return this.warehouseByWarehouseTo;
}

public void setWarehouseByWarehouseTo(Warehouse warehouseByWarehouseTo) {
	this.warehouseByWarehouseTo = warehouseByWarehouseTo;
}


public Warehouse getWarehouseByWarehouseFrom() {
	return this.warehouseByWarehouseFrom;
}

public void setWarehouseByWarehouseFrom(Warehouse warehouseByWarehouseFrom) {
	this.warehouseByWarehouseFrom = warehouseByWarehouseFrom;
}


public String getDescription() {
	return this.description;
}

public void setDescription(String description) {
	this.description = description;
}


public BigDecimal getStartingPrice() {
	return this.startingPrice;
}

public void setStartingPrice(BigDecimal startingPrice) {
	this.startingPrice = startingPrice;
}


public Set<Shipment> getShipments() {
	return this.shipments;
}

public void setShipments(Set<Shipment> shipments) {
	this.shipments = shipments;
}


public Set<PriceList> getPriceLists() {
	return this.priceLists;
}

public void setPriceLists(Set<PriceList> priceLists) {
	this.priceLists = priceLists;
}

}



