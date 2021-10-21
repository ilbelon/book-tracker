package org.belon.booktracker.core.response.exception;



import java.util.HashMap;
import java.util.Map;

import org.belon.booktracker.core.response.ResponseFactory;
import org.belon.booktracker.core.response.exception.customexceptions.PersistenceViolationException;
import org.belon.booktracker.core.response.exception.customexceptions.ResourceNotFoundExceptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/**
 * ControllerAdvice for all generic Error messages
 * 
 * @author Andrea
 *
 */
@ControllerAdvice
public class RestErrorResponseHandler extends ResponseEntityExceptionHandler {

    @Value("${book.tracker.stacktraceOnErrorResponse:false}")
    private boolean printStackTrace;

	
    /**
	 * Override standard method to add a clean list of invalid parameters to response
	 */
	@Override
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex,	HttpHeaders headers, HttpStatus status,	WebRequest request) {
        Map<String, Object> errorMap = errorObject(ex);
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
        	errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return ResponseFactory.generateErrorResponse("Validation error.", HttpStatus.UNPROCESSABLE_ENTITY, errorMap);
    }

	/**
	 * Handle the custom ResourceNotFoundException throw when request try to access a non existing resource
	 */
	@ExceptionHandler(ResourceNotFoundExceptions.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> resourceNotFoundException(ResourceNotFoundExceptions ex, WebRequest request) {
		return ResponseFactory.generateErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND, null);
    }
	
	/**
	 * Handle the custom PersistenceViolationException when request try persist data that violate database constraints
	 */
	@ExceptionHandler(PersistenceViolationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Object> resourceDataIntegrityViolationException(PersistenceViolationException ex, WebRequest request) {
		return ResponseFactory.generateErrorResponse(ex.getMessage(), HttpStatus.CONFLICT, null, ex.getData());
    }
	
	/**
	 * Override standard method to add a clean response that contains name and type of missing parameter.
	 * Doesn't need the @ResponseStatus because it's called by the final method
	 * 
	 * ResponseEntityExceptionHandler (this superclass)
	 * public final ResponseEntity<Object> handleException(Exception ex, WebRequest request)
	 */
	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(
			MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, Object> errorMap = errorObject(ex);
		errorMap.put("name",ex.getParameterName());
		errorMap.put("type", ex.getParameterType());
		return ResponseFactory.generateErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST, errorMap);
	}
	
	@ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleAllUncaughtException(Exception ex, WebRequest request) {
		Map<String, Object> map = errorObject(ex);
		addExceptionMessage(map,ex);
		return ResponseFactory.generateErrorResponse("Internal server Error.", HttpStatus.INTERNAL_SERVER_ERROR, map);
    }
	
	private Map<String, Object> errorObject(Exception ex){
		Map<String, Object> map = new HashMap<>();
		if(printStackTrace) {
        	addStackTrace(map, ex);
        }
		return map;
	}
	
	private void addExceptionMessage(Map<String, Object> map, Exception ex) {
		map.put("error message",ex.getMessage());
	}
	
	private void addStackTrace(Map<String, Object> map, Exception ex) {
		map.put("stacktrace",ex.getStackTrace());
	}
}
