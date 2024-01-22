package com.ajen.inv.model;

import java.io.Serializable;
import java.util.Objects;
/**
 * This class will package the data from service calls wihtin the controller
 * 
 * @author ajenk
 */
public class Result implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String status; 
	
	private String message; 
	
	private String response;

	public Result(String status, String message, String response) {
		super();
		this.status = status;
		this.message = message;
		this.response = response;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	@Override
	public int hashCode() {
		return Objects.hash(message, response, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Result other = (Result) obj;
		return Objects.equals(message, other.message) && Objects.equals(response, other.response)
				&& Objects.equals(status, other.status);
	}

	@Override
	public String toString() {
		return "Result [status=" + status + ", message=" + message + ", response=" + response + "]";
	}
	

}
