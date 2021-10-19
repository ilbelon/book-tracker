package org.belon.booktracker.books.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * Dto for BtBooks
 * 
 * @author andrea
 *
 */
@Data
public class BtBooksDto implements Serializable{

	private static final long serialVersionUID = -595454921106990794L;

	private Long id;
	
	@Size(min=2,max=254,message="Book title length must be between 2 and 254")
	@NotBlank(message="Book title can't be empty")
	private String title;
}
