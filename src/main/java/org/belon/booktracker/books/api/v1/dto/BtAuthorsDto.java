package org.belon.booktracker.books.api.v1.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * Dto for BtAuthors
 * 
 * @author andrea
 *
 */
@Data
public class BtAuthorsDto implements Serializable{

	private static final long serialVersionUID = 8471971764478764244L;

	private Long id;
	
	@NotBlank
	@Size(min=3,max=50,message="Name length must be between 3 and 50")
	private String name;
	
	@NotBlank
	@Size(min=3,max=50,message="Name length must be between 3 and 50")
	private String surname;
}
