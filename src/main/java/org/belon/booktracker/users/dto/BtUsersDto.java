package org.belon.booktracker.users.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.Data;

/**
 * Dto for BtUsers
 * 
 * @author andrea
 *
 */
@Data
public class BtUsersDto implements Serializable{
	
	private static final long serialVersionUID = 5882460036276517749L;

	private Long id;
	
	@NotBlank (message="Name can't be empty")
	private String name;
	
	@NotBlank(message="Username can't be empty")
	private String username;
	
	@NotBlank(message="Email can't be empty")
	private String email;
}
