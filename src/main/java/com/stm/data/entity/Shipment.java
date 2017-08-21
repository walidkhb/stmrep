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
 * Shipment generated by hbm2java
 */
@Entity
@Table(name = "shipment", catalog = "stm")
public class Shipment {

	private long id;
	private Contract contract;
	private Track track;
	private String number;
	private BigDecimal orderWeight;
	private BigDecimal actualPickedUpWeight;
	private BigDecimal actualRecivedWeight;
	private String trukPlatNumber;
	private String description;
	private byte[] recivedWeightReport;
	private byte[] pickUpWeightReport;
	private String status;
	private long id;

	public Shipment() {
	}

	public Shipment(Track track) {
		this.track = track;
	}

	public Shipment(Contract contract, Track track, String number, BigDecimal orderWeight,
			BigDecimal actualPickedUpWeight, BigDecimal actualRecivedWeight, String trukPlatNumber, String description,
			byte[] recivedWeightReport, byte[] pickUpWeightReport, String status) {
		this.contract = contract;
		this.track = track;
		this.number = number;
		this.orderWeight = orderWeight;
		this.actualPickedUpWeight = actualPickedUpWeight;
		this.actualRecivedWeight = actualRecivedWeight;
		this.trukPlatNumber = trukPlatNumber;
		this.description = description;
		this.recivedWeightReport = recivedWeightReport;
		this.pickUpWeightReport = pickUpWeightReport;
		this.status = status;
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
	@JoinColumn(name = "contract_id")
	public Contract getContract() {
		return this.contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "track_id", nullable = false)
	public Track getTrack() {
		return this.track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

	@Column(name = "number", length = 100)
	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Column(name = "order_weight", scale = 3)
	public BigDecimal getOrderWeight() {
		return this.orderWeight;
	}

	public void setOrderWeight(BigDecimal orderWeight) {
		this.orderWeight = orderWeight;
	}

	@Column(name = "actual_picked_up_weight", scale = 3)
	public BigDecimal getActualPickedUpWeight() {
		return this.actualPickedUpWeight;
	}

	public void setActualPickedUpWeight(BigDecimal actualPickedUpWeight) {
		this.actualPickedUpWeight = actualPickedUpWeight;
	}

	@Column(name = "actual_recived_weight", scale = 3)
	public BigDecimal getActualRecivedWeight() {
		return this.actualRecivedWeight;
	}

	public void setActualRecivedWeight(BigDecimal actualRecivedWeight) {
		this.actualRecivedWeight = actualRecivedWeight;
	}

	@Column(name = "truk_plat_number", length = 45)
	public String getTrukPlatNumber() {
		return this.trukPlatNumber;
	}

	public void setTrukPlatNumber(String trukPlatNumber) {
		this.trukPlatNumber = trukPlatNumber;
	}

	@Column(name = "description", length = 250)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "recived_weight_report")
	public byte[] getRecivedWeightReport() {
		return this.recivedWeightReport;
	}

	public void setRecivedWeightReport(byte[] recivedWeightReport) {
		this.recivedWeightReport = recivedWeightReport;
	}

	@Column(name = "pick_up_weight_report")
	public byte[] getPickUpWeightReport() {
		return this.pickUpWeightReport;
	}

	public void setPickUpWeightReport(byte[] pickUpWeightReport) {
		this.pickUpWeightReport = pickUpWeightReport;
	}

	@Column(name = "status", length = 45)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
