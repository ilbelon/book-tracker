package org.belon.booktracker.users.api.v1.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

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
public class BtUsersDto implements Serializable{
	
	private static final long serialVersionUID = 5882460036276517749L;

	@ApiModelProperty(notes = "Unique identifier of the User", example = "43", required = false, position = 0)
	private Long id;
	
	@ApiModelProperty(notes = "Name of User", example = "Jhon Smith", required = true, position = 1)
	@NotBlank (message="Name can't be empty")
	private String name;
	
	@ApiModelProperty(notes = "Username of User.", example = "jhonsm86", required = true, position = 2)
	@NotBlank(message="Username can't be empty")
	private String username;
	
	@ApiModelProperty(notes = "Email of User", example = "jhonsm86@example.org", required = true, position = 3)
	@NotBlank(message="Email can't be empty")
	private String email;
}
