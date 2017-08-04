package com.mrinal.response;

import java.util.Date;

public class SportsResponse {

	public String getSportsId() {
		return sportsId;
	}
	public void setSportsId(String sportsId) {
		this.sportsId = sportsId;
	}
	private String sportsId;
	private String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private String successMessage;
	private String errorMessage;
	private String sportsName;
	private String host;
	private String venue;
	private String date;
	private String time;
	private String description;
	public String getSuccessMessage() {
		return successMessage;
	}
	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getSportsName() {
		return sportsName;
	}
	public void setSportsName(String sportsName) {
		this.sportsName = sportsName;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
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
	
	public SportsResponse(String sportsId, String status, String successMessage, String errorMessage, String sportsName,
			String host, String venue, String date, String time, String description) {
		super();
		this.sportsId = sportsId;
		this.status = status;
		this.successMessage = successMessage;
		this.errorMessage = errorMessage;
		this.sportsName = sportsName;
		this.host = host;
		this.venue = venue;
		this.date = date;
		this.time = time;
		this.description = description;
	}
	public SportsResponse(String status, String successMessage, String errorMessage, String sportsName, String host,
			String venue, String date, String time, String description) {
		super();
		this.status = status;
		this.successMessage = successMessage;
		this.errorMessage = errorMessage;
		this.sportsName = sportsName;
		this.host = host;
		this.venue = venue;
		this.date = date;
		this.time = time;
		this.description = description;
	}
	public SportsResponse(String status, String errorMessage) {
		super();
		this.status = status;
		this.errorMessage = errorMessage;
	}
	
	
}
