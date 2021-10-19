package org.belon.booktracker.books.dto;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

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
	
	@NotBlank(message="Book can't be null")
	private BtBooksDto book;
	
	@NotBlank(message="Serie can't be null")
	private BtSeriesDto serie;
	
	@NotBlank(message="Number of this book in series can't be null")
	@Min(value=1,message="The book number in serie can't be lesser than 1")
	private int numberOfThisBookInSeries;
	
}
