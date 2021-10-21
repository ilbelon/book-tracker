package org.belon.booktracker.core.response;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Factory to handle ResponseEntity creation
 * 
 * @author Andrea
 *
 */
public class ResponseFactory {

	/**
	 * Used to instantiate a succesfull ResponseEntity
	 * 
	 * @param message Returned message
	 * @param status HttpStatus of request
	 * @param responseObj Object containing resource requested
	 * @return a ResponseEntity containig a map with message, HttpStatus and resource requested.
	 */
	public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj) {
		Map<String, Object> map = getBaseMap(message,status);
		map.put("data", responseObj);
		return new ResponseEntity<>(map,status);
    }
	
	/**
	 * Used to instantiate a failed ResponseEntity
	 * 
	 * @param errorMessage Exception message
	 * @param status HttpStatus of request
	 * @param errorObject Optional exception data need to be added to ResponseEntity
	 * @return a ResponseEntity containig a map with message, HttpStatus and resource requested.
	 */
	public static ResponseEntity<Object> generateErrorResponse(String errorMessage, HttpStatus status, Object errorObject) {
		Map<String, Object> map = getBaseMap(errorMessage,status);
		if (errorObject!=null) {
			map.put("error", errorObject);
		}
		return new ResponseEntity<>(map,status);
    }
	
	/**
	 * Used to instantiate a failed ResponseEntity with optional additional resource
	 * Example:
	 * if an user try to insert an already existent Author (name,surname combination already present in persistence)
	 * an error response will be returned with the Author already in database as additional data
	 * 
	 * @param errorMessage Exception message
	 * @param status HttpStatus of request
	 * @param errorObject Optional exception data need to be added to ResponseEntity
	 * @param additionalData Optional exception data need to be added to ResponseEntity
	 * @return a ResponseEntity containing a map with message, HttpStatus and resource requested.
	 */
	public static ResponseEntity<Object> generateErrorResponse(String errorMessage, HttpStatus status, Object errorObject, Object additionalData) {
		Map<String, Object> map = getBaseMap(errorMessage,status);
		if (errorObject!=null) {
			map.put("error", errorObject);
		}
		if (additionalData!=null) {
			map.put("data", additionalData);
		}
		return new ResponseEntity<>(map,status);
    }
	
	/**
	 * Used to instantiate base map for every response with
	 * 
	 * @param message Contains a message. Example: "Book created"
	 * @param status Contains HttpStatus of request. Example: "404"
	 * @return a base map to create every Response Entity
	 */
	private static Map<String, Object> getBaseMap(String message, HttpStatus status){
		Map<String, Object> map = new HashMap<>();
		map.put("message", message);
		map.put("status", status.value());
		return map;
	}
}
