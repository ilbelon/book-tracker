package org.belon.booktracker.books.api.v1.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Dto class for BtSettings
 * 
 * @author andrea
 *
 */
@Data
public class BtSettingDto implements Serializable{

	private static final long serialVersionUID = 6761420234353857155L;

	@ApiModelProperty(notes = "Unique identifier of the Setting", example = "23", required = false, position = 0)
	private Long id;
	
	@ApiModelProperty(notes = "Name of the Setting", example = "Dragonlance", required = true, position = 1)
	@NotBlank(message="Name can't be empty")
	@Size(min=2,max=254,message="Name length must be between 2 and 254")
	private String name;
}
