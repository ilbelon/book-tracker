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
@ApiModel(description = "Class representing a Setting where one or more books stories are placed")
@Data
public class BtSettings implements Serializable{

	private static final long serialVersionUID = 5401408144750200754L;
	
	/**
	 * Unique identifier of the setting.
	 */
	private Long id;
	
	/**
	 * Name of the setting.
	 */
//	@ApiModelProperty(notes = "Name of the setting.", example = "Forgottens Realms", required = true, position = 1)
	@NotBlank
	private String name;
	
	/**
	 * Books in this setting.
	 */
//	@ApiModelProperty(notes = "Books in this setting.", required = false, position = 2, dataType = "BtBooks")
	private Set<BtBooks> books;

}
