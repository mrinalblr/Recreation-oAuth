package com.mrinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="TREKKING")
public class Trekking {

	@Id
	@GeneratedValue
	@Column(name="TREKK_ID")
	private int trekkId;
	@Column(name="TREKK_NAME")
	private String trekkName;
	@Column(name="TREKK_LOCATION")
	private String trekkLocation;
	@Column(name="TREKK_HOST")
	private String trekkHost;
	@Column(name="TREKK_DATE")
	private String trekkDate;
	@Column(name="TREKK_TIME")
	private String trekkTime;
	@Column(name="TREKK_DESC")
	private String trekkDesc;
	public Trekking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Trekking(String trekkName, String trekkLocation, String trekkHost, String trekkDate, String trekkTime,
			String trekkDesc) {
		super();
		this.trekkName = trekkName;
		this.trekkLocation = trekkLocation;
		this.trekkHost = trekkHost;
		this.trekkDate = trekkDate;
		this.trekkTime = trekkTime;
		this.trekkDesc = trekkDesc;
	}
	public int getTrekkId() {
		return trekkId;
	}
	public void setTrekkId(int trekkId) {
		this.trekkId = trekkId;
	}
	public String getTrekkName() {
		return trekkName;
	}
	public void setTrekkName(String trekkName) {
		this.trekkName = trekkName;
	}
	public String getTrekkLocation() {
		return trekkLocation;
	}
	public void setTrekkLocation(String trekkLocation) {
		this.trekkLocation = trekkLocation;
	}
	public String getTrekkHost() {
		return trekkHost;
	}
	public void setTrekkHost(String trekkHost) {
		this.trekkHost = trekkHost;
	}
	public String getTrekkTime() {
		return trekkTime;
	}
	public void setTrekkTime(String trekkTime) {
		this.trekkTime = trekkTime;
	}
	public String getTrekkDesc() {
		return trekkDesc;
	}
	public void setTrekkDesc(String trekkDesc) {
		this.trekkDesc = trekkDesc;
	}
	
}
