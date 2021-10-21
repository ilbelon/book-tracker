package org.belon.booktracker.core.response.exception.customexceptions;

import lombok.Getter;
import lombok.Setter;

/**
 * Exception to manage persistence violation. 
 * Example: 
 * inserting an User with same username
 * 
 * May contain additional data.
 * Example: 
 * an user try to insert an author already present (same combination of name,surname)
 * the already present author is returned in data
 * 
 * @author Andrea
 *
 */
@Getter
@Setter
public class PersistenceViolationException extends RuntimeException{

	private static final long serialVersionUID = -4724479095517879445L;

	Object data;
	
	public PersistenceViolationException(String msg) {
	    super(msg);
	}
	
	public PersistenceViolationException(String msg, Object data) {
		super(msg);
		this.data=data;
	}
	
}
