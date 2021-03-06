package com.stm.data.entity;
// Generated Jul 31, 2017 10:22:15 PM by Hibernate Tools 5.2.3.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Cargo generated by hbm2java
 */
@Entity
@Table(name = "cargo", catalog = "stm")
public class Cargo {

	private long id;
	private String name;
	private String unit;
	private String description;
	private Set<PriceList> priceLists = new HashSet<PriceList>(0);

	public Cargo() {
	}

	public Cargo(String name, String unit, String description, Set<PriceList> priceLists) {
		this.name = name;
		this.unit = unit;
		this.description = description;
		this.priceLists = priceLists;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "name", length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "unit", length = 45)
	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Column(name = "description", length = 45)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cargo")
	public Set<PriceList> getPriceLists() {
		return this.priceLists;
	}

	public void setPriceLists(Set<PriceList> priceLists) {
		this.priceLists = priceLists;
	}

}
