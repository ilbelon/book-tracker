package org.belon.booktracker.core.response.exception.customexceptions;

public class ResourceNotFoundExceptions extends RuntimeException{

	private static final long serialVersionUID = -5149302552414341262L;
	
	public ResourceNotFoundExceptions(String msg) {
	    super(msg);
	  }
	
}
