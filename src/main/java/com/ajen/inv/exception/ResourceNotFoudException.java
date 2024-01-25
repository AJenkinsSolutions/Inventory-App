package com.ajen.inv.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mysql.cj.protocol.Message;

/**
 * This class represents an exception that should be thrown when a requested resource is not found.
 * 
 * @author ajenk
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoudException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public ResourceNotFoudException(String message) {
		
		super(message);
	}
	
	
	

}
