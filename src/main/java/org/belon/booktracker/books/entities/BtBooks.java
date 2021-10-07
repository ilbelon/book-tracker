package org.belon.booktracker.books.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author andrea
 *
 */
@ApiModel(description = "Class representing a Book in the application.")
@Entity
@Data
public class BtBooks implements Serializable {

	private static final long serialVersionUID = 3125821555736931409L;
	
	/**
	 * Unique identifier of the Book.
	 */
//	@ApiModelProperty(notes = "Unique identifier of the Book.", example = "1", required = true, position = 0)
	@Id
	private Long id;
	
	/**
	 * Title of the Book.
	 */
//	@ApiModelProperty(notes = "Title of the Book.", example = "Pinocchio", required = true, position = 1)
	@NotBlank
	private String title;
	
	/**
	 * Authors of the Book.
	 */
//	@ApiModelProperty(notes = "Authors of the Book.", required = true, position = 2, dataType = "BtAuthors")
//	@NotBlank
//	private Set<BtAuthors> author;
	
}
