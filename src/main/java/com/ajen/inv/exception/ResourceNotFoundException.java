package com.ajen.inv.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mysql.cj.protocol.Message;

/**
 * This class represents an exception that should be thrown when a requested resource is not found.
 * This is basically just an extension of the RunTimeException
 * 
 * @author ajenk
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public ResourceNotFoundException(String message) {
		
		super(message);
	}
	
	
	

}
