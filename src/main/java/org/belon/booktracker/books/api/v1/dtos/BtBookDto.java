package org.belon.booktracker.books.api.v1.dtos;

import java.io.Serializable;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Dto for BtBooks
 * 
 * @author andrea
 *
 */
@Data
public class BtBookDto implements Serializable{

	private static final long serialVersionUID = -595454921106990794L;

	@ApiModelProperty(notes = "Unique identifier of the Book", example = "23", required = false, position = 0)
	private Long id;
	
	@ApiModelProperty(notes = "Title of Book", example = "Shining", required = true, position = 1)
	@Size(min=2,max=254,message="Book title length must be between 2 and 254")
	@NotBlank(message="Book title can't be empty")
	private String title;
	
	@ApiModelProperty(notes = "Authors of Book", required = true, position = 2)
	@NotEmpty(message="Author should be provided")
	private Set<BtAuthorDto> authors;
	
	private BtSettingDto setting;
}
