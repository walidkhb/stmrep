package com.stm.data.entity;
// Generated Jul 31, 2017 10:22:15 PM by Hibernate Tools 5.2.3.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * PriceList generated by hbm2java
 */
@Entity
@Table(name = "price_list", catalog = "stm")
public class PriceList {

	private long id;
	private Cargo cargo;
	private Track track;
	private BigDecimal priceLorry;
	private BigDecimal priceDiana;
	private BigDecimal priceOnet;

	public PriceList() {
	}

	public PriceList(Cargo cargo, Track track, BigDecimal priceLorry, BigDecimal priceDiana, BigDecimal priceOnet) {
		this.cargo = cargo;
		this.track = track;
		this.priceLorry = priceLorry;
		this.priceDiana = priceDiana;
		this.priceOnet = priceOnet;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cargo_id")
	public Cargo getCargo() {
		return this.cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "track_id")
	public Track getTrack() {
		return this.track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

	@Column(name = "price_lorry", scale = 3)
	public BigDecimal getPriceLorry() {
		return this.priceLorry;
	}

	public void setPriceLorry(BigDecimal priceLorry) {
		this.priceLorry = priceLorry;
	}

	@Column(name = "price_diana", scale = 3)
	public BigDecimal getPriceDiana() {
		return this.priceDiana;
	}

	public void setPriceDiana(BigDecimal priceDiana) {
		this.priceDiana = priceDiana;
	}

	@Column(name = "price_onet", scale = 3)
	public BigDecimal getPriceOnet() {
		return this.priceOnet;
	}

	public void setPriceOnet(BigDecimal priceOnet) {
		this.priceOnet = priceOnet;
	}

}
