package com.ajen.inv.exception;

import org.springframework.http.HttpStatus;

/**
 * 
 * Custom exception class for API-related errors within the application.
 * This exception class allows for a specific HTTP status and a custom error code 
 * to be associated with an exception, enabling more detailed error responses for API clients.
 * 
 * @author ajenk
 */
public class ApiException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final HttpStatus status;
	
    private final String errorCode;

    /**
     * Constructs a new ApiException with the specified detail message, status, and error code.
     *
     * @param status the HttpStatus code associated with the exception.
     * @param message the detail message. The detail message is saved for later retrieval by the getMessage() method.
     * @param errorCode a specific error code associated with the exception.
     */
    public ApiException(HttpStatus status, String message, String errorCode) {
        super(message);
        this.status = status;
        this.errorCode = errorCode;
    }

    /**
     * Retrieves the HttpStatus associated with the exception.
     * This status code can be used in the HTTP response.
     *
     * @return the HttpStatus code.
     */
    public HttpStatus getStatus() {
        return status;
    }

    /**
     * Retrieves the specific error code associated with the exception.
     * This error code can provide additional information about the nature of the error.
     *
     * @return the error code as a String.
     */
    public String getErrorCode() {
        return errorCode;
    }

}
