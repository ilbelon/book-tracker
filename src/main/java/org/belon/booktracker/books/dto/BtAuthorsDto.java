package org.belon.booktracker.books.dto;

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
	@Size(min=5,max=50,message="Name length must be between 5 and 50")
	private String name;
}
