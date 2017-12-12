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
	@Column(name="TRIP_ORIGIN")
	private String origin;
	@Column(name="TRIP_DESTINATION")
	private String destination;
	@Column(name="TRIP_HOST")
	private String host;
	@Column(name="TRIP_TYPE")
	private String tripType;
	@Column(name="TRIP_DATE")
	private String date;
	@Column(name="TRIP_TIME")
	private String time;
	@Column(name="TRIP_DESC")
	private String description;
	
	public RoadTrips(String tripName, String origin, String destination, String host, String tripType,
			String date, String time, String description) {
		super();
		this.tripName = tripName;
		this.origin = origin;
		this.destination = destination;
		this.host = host;
		this.tripType = tripType;
		this.date = date;
		this.time = time;
		this.description = description;
	}
	public RoadTrips() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTripName() {
		return tripName;
	}
	public void setTripName(String tripName) {
		this.tripName = tripName;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getTripType() {
		return tripType;
	}
	public void setTripType(String tripType) {
		this.tripType = tripType;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
