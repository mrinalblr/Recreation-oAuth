package com.mrinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="ROAD_TRIPS")
public class RoadTrips {

	@Id
	@GeneratedValue
	@Column(name="TRIP_ID")
	private int trip_Id;
	@Column(name="TRIP_NAME")
	private String tripName;
	@Column(name="TRIP_HOST")
	private String tripHost;
	@Column(name="TRIP_LOCATION")
	private String tripLocation;
	@Column(name="TRIP_DATE")
	private String tripDate;
	@Column(name="TRIP_TIME")
	private String tripTime;
	@Column(name="TRIP_DESC")
	private String tripDesc;
	public RoadTrips() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RoadTrips(String tripName, String tripHost, String tripLocation, String tripDate, String tripTime,
			String tripDesc) {
		super();
		this.tripName = tripName;
		this.tripHost = tripHost;
		this.tripLocation = tripLocation;
		this.tripDate = tripDate;
		this.tripTime = tripTime;
		this.tripDesc = tripDesc;
	}
	public String getTripName() {
		return tripName;
	}
	public void setTripName(String tripName) {
		this.tripName = tripName;
	}
	public String getTripHost() {
		return tripHost;
	}
	public void setTripHost(String tripHost) {
		this.tripHost = tripHost;
	}
	public String getTripLocation() {
		return tripLocation;
	}
	public void setTripLocation(String tripLocation) {
		this.tripLocation = tripLocation;
	}
	public String getTripDate() {
		return tripDate;
	}
	public void setTripDate(String tripDate) {
		this.tripDate = tripDate;
	}
	public String getTripTime() {
		return tripTime;
	}
	public void setTripTime(String tripTime) {
		this.tripTime = tripTime;
	}
	public String getTripDesc() {
		return tripDesc;
	}
	public void setTripDesc(String tripDesc) {
		this.tripDesc = tripDesc;
	}
	
	
}
