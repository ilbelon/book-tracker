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
@ApiModel(description = "Class representing an Author in the application.")
@Data
public class BtAuthors implements Serializable{

	private static final long serialVersionUID = -1959474518190676963L;
	
	/**
	 * Unique identifier of the author.
	 */
//	@ApiModelProperty(notes = "Unique identifier of the author.", example = "1", required = true, position = 0)
	private Long id;
	
	/**
	 * Name of the Author
	 */
//	@ApiModelProperty(notes = "Name of the Author", example = "Collodi", required = true, position = 1)
	@NotBlank
	private String name;
	
	/**
	 * Books written by the Author
	 */
//	@ApiModelProperty(notes = "Books written by the Author", required = false, position = 2, dataType = "BtBooks")
	private Set<BtBooks> books;
}
