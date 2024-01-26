package com.ajen.inv.exception;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ajen.inv.controller.InventoryController;

/**
 * Intercept exceptions thrown by methods annotated with @RequestMapping
 * 
 * @author ajenk
 */
@ControllerAdvice
public class GlobalExceptionHandler implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	/**
	 * Handles ResourceNotFoundExceptions thrown when a requested resource is not found.
	 * 
	 * @param ex The exception thrown when a resource is not found.
	 * @return A ResponseEntity containing an ApiErrorResponse with details of the exception.
	 * @author ajenk
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
		
        logger.error("Resource not found: {}", ex.getMessage());
        
        ApiErrorResponse response = new ApiErrorResponse(LocalDateTime.now(), ex.getMessage(), "RESOURCE_NOT_FOUND");
        
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
	
	/**
	 * Handles general exceptions that are not caught by more specific handlers.
	 * This acts as a catch-all for unexpected server errors
	 * 
	 * @param ex The general exception encountered by the application.
	 * @return A ResponseEntity containing an ApiErrorResponse with a generic error message.
	 * @author ajenk
	 */
 	@ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleGeneralException(Exception ex) {
        logger.error("An error occurred: {}", ex.getMessage());
        ApiErrorResponse response = new ApiErrorResponse(LocalDateTime.now(), "An internal error occurred", "INTERNAL_SERVER_ERROR");
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
 	
 	/**
 	 * Handles custom ApiException instances with specific error codes and statuses.
 	 *
 	 * @param ex The ApiException thrown from the application.
 	 * @return A ResponseEntity containing an ApiErrorResponse with details of the ApiException.
 	 * @author ajenk
 	 */
	 @ExceptionHandler(ApiException.class)
	 public ResponseEntity<ApiErrorResponse> handleApiException(ApiException ex) {
	     logger.error("API exception: {}", ex.getMessage());
	     ApiErrorResponse response = new ApiErrorResponse(LocalDateTime.now(), ex.getMessage(), ex.getErrorCode());
	     return new ResponseEntity<>(response, ex.getStatus());
	 }
  
    


}
