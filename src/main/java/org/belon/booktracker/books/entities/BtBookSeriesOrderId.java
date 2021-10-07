package org.belon.booktracker.books.entities;

import java.io.Serializable;

import lombok.Data;

/**
 * Id class for BtBookSeriesOrder Class
 * 
 * @author andrea
 *
 */
@Data
public class BtBookSeriesOrderId implements Serializable {

	private static final long serialVersionUID = 4505442923004170635L;

	private Long book;
	
	private Long serie;
}
