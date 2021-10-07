package org.belon.booktracker.userdata.entities;

import java.io.Serializable;

import lombok.Data;

/**
 * Id class for BtCharactersBond Class
 * 
 * @author andrea
 *
 */
@Data
public class BtCharactersBondId implements Serializable{

	private static final long serialVersionUID = -8724242181913212391L;

	private Long character1;
	
	private Long character2;
}
