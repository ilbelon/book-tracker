package org.belon.booktracker.core.response.exception.customexceptions;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -5149302552414341262L;
	
	public ResourceNotFoundException(String msg) {
	    super(msg);
	  }
	
}
