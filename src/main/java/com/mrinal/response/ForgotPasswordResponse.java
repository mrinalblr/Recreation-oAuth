package com.mrinal.response;

public class ForgotPasswordResponse {

	private String status;
	private String successMessage;
	private String errorMessage;
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
	public ForgotPasswordResponse(String status, String successMessage, String errorMessage) {
		super();
		this.status = status;
		this.successMessage = successMessage;
		this.errorMessage = errorMessage;
	}
	public ForgotPasswordResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
