package org.belon.booktracker.books.entities;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author andrea
 *
 */
@ApiModel(description = "Class representing ManyToMany relationship between books and series")
@Data
public class BtBookSeriesOrder implements Serializable {

	private static final long serialVersionUID = -121340344346838183L;
	
	/**
	 * Books FK.
	 */
//	@ApiModelProperty(notes = "Books FK.", required = true, position = 0, dataType = "BtBooks")
	private BtBooks book;
	
	/**
	 * Serie FK.
	 */
//	@ApiModelProperty(notes = "Serie FK.", required = true, position = 1, dataType = "BtSeries")
	private BtSeries serie;
	
	/**
	 * Number representing the order of this book in the series
	 */
//	@ApiModelProperty(notes = "Number representing the order of this book in the series", example = "2", required = true)
	@NotBlank
	private int order;
}
