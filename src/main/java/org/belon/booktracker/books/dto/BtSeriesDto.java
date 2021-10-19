package org.belon.booktracker.books.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * Dto for BtSeries
 * 
 * @author andrea
 *
 */
@Data
public class BtSeriesDto implements Serializable {

	private static final long serialVersionUID = -1299595905883908008L;
	
	private Long id;
	
	@NotBlank(message="Serie name can't be empty")
	@Size(min=2,max=254,message="Serie name length must be between 2 and 254")
	private String name;

}
