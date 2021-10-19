package org.belon.booktracker.userdata.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * Association Dtoclass between Users and Books.
 * Every data inserted by an user about a book will have a reference to this table.
 * 
 * @author andrea
 *
 */
@Data
public class BtUserBookAssociationDto implements Serializable{

	private static final long serialVersionUID = 1009961008462190649L;

}
