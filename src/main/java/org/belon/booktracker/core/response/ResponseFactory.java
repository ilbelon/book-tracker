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

	public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj) {
		Map<String, Object> map = getBaseMap(message,status);
		map.put("data", responseObj);
		return new ResponseEntity<>(map,status);
    }
	
	public static ResponseEntity<Object> generateErrorResponse(String message, HttpStatus status, Object responseObj) {
		Map<String, Object> map = getBaseMap(message,status);
		if (responseObj!=null) {
			map.put("error", responseObj);
		}
		return new ResponseEntity<>(map,status);
    }
	
	private static Map<String, Object> getBaseMap(String message, HttpStatus status){
		Map<String, Object> map = new HashMap<>();
		map.put("message", message);
		map.put("status", status.value());
		return map;
	}
}
