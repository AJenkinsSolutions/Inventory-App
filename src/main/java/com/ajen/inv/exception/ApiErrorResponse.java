package com.ajen.inv.exception;


import java.time.LocalDateTime;
/**
 * This class serves as a standard formatted response for errors. 
 * includes a detailed time stamp, message and a custom error code. 
 * 
 * @author ajenk
 */
public class ApiErrorResponse {
	
	private LocalDateTime timeStamp; 
	
	private String message;
	
	private String errorCode;


	ApiErrorResponse(LocalDateTime now, String message, String errorCode) {
		this.timeStamp = now; 
		this.message = message;
		this.errorCode = errorCode; 
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	} 
	
	// Other fields like 'details' can be added for more information
	
	
	

	
	

}
