package org.belon.booktracker.books.entities;

import java.io.Serializable;
import java.util.Set;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author andrea
 *
 */
@ApiModel(description = "Class representing a Serie of books")
@Data
public class BtSeries implements Serializable{

	private static final long serialVersionUID = -1018158729276258248L;
	
	/**
	 * Unique identifier of the serie.
	 */
//	@ApiModelProperty(notes = "Unique identifier of the serie.", example = "1", required = true, position = 0)
	private Long id;
	
	/**
	 * Name of the series.
	 */
//	@ApiModelProperty(notes = "Name of the series.", example = "Legend of Drizzt", required = true, position = 1)
	@NotBlank
	private String name;
	
	/**
	 * Books in this series.
	 */
//	@ApiModelProperty(notes = "Books in this series.", required = false, position = 2, dataType = "BtBooks")
	private Set<BtBooks> books;

}
