package com.ajen.inv.exception;
/**
 * This class serves as a standard formatted response for errors. 
 * includes a detailed time stamp, message and a custom error code. 
 * 
 * @author ajenk
 */

import java.time.LocalDateTime;
/**
 * 
 * 
 * @author ajenk
 */
public class ApiErrorResponse {
	
	private LocalDateTime timeStamp; 
	
	private String message;
	
	private String errorCode;

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
