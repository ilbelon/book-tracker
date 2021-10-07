package org.belon.booktracker.userdata.entities;

import java.io.Serializable;

import lombok.Data;

/**
 * Id class for BtBookAuthor Class
 * 
 * @author andrea
 *
 */
@Data
public class BtUserBookAssociationId implements Serializable {

	private static final long serialVersionUID = 4529196066425516001L;

	private Long book;
	
	private Long user;
}
