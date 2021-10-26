package org.belon.booktracker.books.api.v1.dtos;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
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

	@ApiModelProperty(notes = "Unique identifier of the BookSerieNumber", example = "23", required = false, position = 0)
	private Long id;
	
	@ApiModelProperty(notes = "Book in BookSerieNumber", required = true, position = 1)
	@NotNull(message="Book can't be null")
	private BtBookDto book;
	
	@ApiModelProperty(notes = "Serie in BookSerieNumber", required = true, position = 2)
	@NotNull(message="Serie can't be null")
	private BtSerieDto serie;
	
	@ApiModelProperty(notes = "Number representing order of Book in the Serie", required = true, position = 3)
	@Min(value=1,message="The book number in serie can't be lesser than 1")
	private int numberOfThisBookInSeries;
	
}
