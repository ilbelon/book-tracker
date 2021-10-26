package org.belon.booktracker.userdata.api.v1.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Dto for BtUsers
 * 
 * @author andrea
 *
 */
@Data
@ApiModel (value = "User", description = "User of application")
public class BtUserBookAssociationIdDto implements Serializable{
	
	private static final long serialVersionUID = 5882460036276517749L;

	@ApiModelProperty(notes = "Unique identifier of the User", example = "3", required = false, position = 0)
	@NotNull (message="user can't be empty")
	private Long user;
	
	@ApiModelProperty(notes = "Unique identifier of the Book", example = "1", required = true, position = 1)
	@NotNull (message="book can't be empty")
	private Long book;
}
