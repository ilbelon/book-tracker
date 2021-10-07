package org.belon.booktracker.books.entities;

import java.io.Serializable;
import java.util.Set;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "Class representing a Book in the application.")

@Data
public class BtBooks implements Serializable {

	private static final long serialVersionUID = 3125821555736931409L;

	@ApiModelProperty(notes = "Unique identifier of the Book.", example = "1", required = true, position = 0)
	private Long id;
	
	@ApiModelProperty(notes = "Title of the Book.", example = "1", required = true, position = 1)
	@NotBlank
	private String title;
	
	
	private Set<BtAuthors> author;
	
	private String ISBN;
	
	private String publisher;
	
}
