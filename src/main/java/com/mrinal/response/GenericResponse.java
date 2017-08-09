package com.mrinal.response;

import org.springframework.http.HttpStatus;

public class GenericResponse {

	private String status;
	private String successMessage;
	private String errorMessage;
	private HttpStatus statusCode;
	
	public GenericResponse(String status, String successMessage, String errorMessage, HttpStatus statusCode) {
		super();
		this.status = status;
		this.successMessage = successMessage;
		this.errorMessage = errorMessage;
		this.statusCode = statusCode;
	}
	public HttpStatus getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
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
	public GenericResponse(String status, String successMessage, String errorMessage) {
		super();
		this.status = status;
		this.successMessage = successMessage;
		this.errorMessage = errorMessage;
	}
	public GenericResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
}
