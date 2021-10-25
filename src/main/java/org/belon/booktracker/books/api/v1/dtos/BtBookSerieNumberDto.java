package org.belon.booktracker.books.api.v1.dtos;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * Dto for BtBookSerieNumber
 *
 * @author andrea
 *
 */
@Data
public class BtBookSerieNumberDto implements Serializable{

	private static final long serialVersionUID = -3894818133029516733L;

	private Long id;
	
	@NotNull(message="Book can't be null")
	private BtBookDto book;
	
	@NotNull(message="Serie can't be null")
	private BtSerieDto serie;
	
	@Min(value=1,message="The book number in serie can't be lesser than 1")
	private int numberOfThisBookInSeries;
	
}
