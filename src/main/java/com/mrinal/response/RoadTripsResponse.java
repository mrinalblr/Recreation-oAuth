package com.mrinal.response;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.mrinal.model.RoadTrips;

public class RoadTripsResponse extends GenericResponse {

	private List<RoadTrips> trips;

	public RoadTripsResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoadTripsResponse(String status, String successMessage, String errorMessage, HttpStatus statusCode) {
		super(status, successMessage, errorMessage, statusCode);
		// TODO Auto-generated constructor stub
	}

	public RoadTripsResponse(String status, String successMessage, String errorMessage) {
		super(status, successMessage, errorMessage);
		// TODO Auto-generated constructor stub
	}

	public List<RoadTrips> getTrips() {
		return trips;
	}

	public void setTrips(List<RoadTrips> trips) {
		this.trips = trips;
	}

	public RoadTripsResponse(String status, String successMessage, String errorMessage, HttpStatus statusCode,
			List<RoadTrips> trips) {
		super(status, successMessage, errorMessage, statusCode);
		this.trips = trips;
	}
	
	
}
