package org.belon.booktracker.books.api.v1.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Dto for BtSeries
 * 
 * @author andrea
 *
 */
@Data
public class BtSerieDto implements Serializable {

	private static final long serialVersionUID = -1299595905883908008L;
	
	@ApiModelProperty(notes = "Unique identifier of the Serie", example = "23", required = false, position = 0)
	private Long id;
	
	@ApiModelProperty(notes = "Name of the Serie", example = "Lord of the Rings", required = true, position = 1)
	@NotBlank(message="Serie name can't be empty")
	@Size(min=2,max=254,message="Serie name length must be between 2 and 254")
	private String name;

}
