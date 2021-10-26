package org.belon.booktracker.books.api.v1.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Dto for BtAuthors
 * 
 * @author andrea
 *
 */
@Data
public class BtAuthorDto implements Serializable{

	private static final long serialVersionUID = 8471971764478764244L;

	@ApiModelProperty(notes = "Unique identifier of the Author", example = "23", required = false, position = 0)
	private Long id;
	
	@ApiModelProperty(notes = "Name of Author", example = "Jhon", required = true, position = 1)
	@NotBlank(message="Name can't be empty")
	@Size(min=3,max=50,message="Name length must be between 3 and 50")
	private String name;
	
	@ApiModelProperty(notes = "Surname of Author", example = "Smith", required = true, position = 2)
	@NotBlank(message="Surname can't be empty")
	@Size(min=3,max=50,message="Name length must be between 3 and 50")
	private String surname;
}
