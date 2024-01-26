package com.ajen.inv.GlobalExceptionHandler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ajen.inv.exception.ApiErrorResponse;
import com.ajen.inv.exception.ApiException;
import com.ajen.inv.exception.GlobalExceptionHandler;
import com.ajen.inv.exception.ResourceNotFoundException;
import com.fasterxml.jackson.core.sym.Name;

/**
 * 
 * 
 * @author ajenk
 */
@ExtendWith(MockitoExtension.class)
public class GlobalExceptionHandlerTests {
	
	
	private GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();
	
	/**
	 * This test will check if the method correctly handles ResourceNotFoundException 
	 * and returns the expected ResponseEntity.
	 * 
	 * @author ajenk
	 */
	@DisplayName("Handle Resource Not Found Exception Test ")
    @Test
    public void testHandleResourceNotFoundException() {
        ResourceNotFoundException ex = new ResourceNotFoundException("Resource not found");
        ResponseEntity<ApiErrorResponse> response = globalExceptionHandler.handleResourceNotFoundException(ex);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Resource not found", response.getBody().getMessage());
        assertEquals("RESOURCE_NOT_FOUND", response.getBody().getErrorCode());
    }
	
	/**
	 * This test will verify that the handler properly responds to ApiException with the correct status and message.
	 * @author ajenk
	 */
	@DisplayName("Handle Api Exception Test")
	@Test
	public void testHandleApiException() {
	    ApiException ex = new ApiException(HttpStatus.BAD_REQUEST, "Custom API error", "CUSTOM_ERROR");
	    ResponseEntity<ApiErrorResponse> response = globalExceptionHandler.handleApiException(ex);

	    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	    assertEquals("Custom API error", response.getBody().getMessage());
	    assertEquals("CUSTOM_ERROR", response.getBody().getErrorCode());
	}
	/**
	 * This test ensures that the handler provides a generic response for uncaught exceptions.
	 * 
	 * @author ajenk
	 */
	@DisplayName("Handle General Exception Test")
	@Test
	public void testHandleGeneralException() {
	    Exception ex = new Exception("General error");
	    ResponseEntity<ApiErrorResponse> response = globalExceptionHandler.handleGeneralException(ex);

	    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
	    assertEquals("An internal error occurred", response.getBody().getMessage());
	    assertEquals("INTERNAL_SERVER_ERROR", response.getBody().getErrorCode());
	}

	
	
	

}
