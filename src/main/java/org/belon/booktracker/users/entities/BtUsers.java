package org.belon.booktracker.users.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Data;

/**
 * Class reprenting an user in the application
 * 
 * @author andrea
 *
 */
@Entity
@Data
public class BtUsers implements Serializable{

	private static final long serialVersionUID = -5804607614843445220L;

	/**
	 * Unique identifier of the user.
	 */
	@Id
	private Long id;
	
	/**
	 * User name.
	 */
	@Column
	@NotBlank
	private String name;
	
	/**
	 * User username.
	 */
	@Column
	@NotBlank
	private String username;
	
	/**
	 * User email.
	 */
	@Column
	@NotBlank
	private String email;
	
	/**
	 * User registration date.
	 */
	@Column
	@NotBlank
	private LocalDate registrationDate;
	
//	private Set<BtUserBookAssociation> bookAssociation;
	
}
