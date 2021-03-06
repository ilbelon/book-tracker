package org.belon.booktracker.users.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.belon.booktracker.userdata.entities.BtUserBookAssociation;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Class reprenting an user in the application
 * 
 * @author andrea
 *
 */
@Entity
@Data
public class BtUser implements Serializable{

	private static final long serialVersionUID = -5804607614843445220L;

	/**
	 * Unique identifier of the user.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * User name.
	 */
	@Column
	@NotBlank (message="Name can't be empty")
	private String name;
	
	/**
	 * User username.
	 */
	@Column(unique=true, name="USERNAME")
	@NotBlank(message="Username can't be empty")
	private String username;
	
	/**
	 * User email.
	 */
	@Column(unique=true, name="EMAIL")
	@NotBlank(message="Email can't be empty")
	@Email
	private String email;
	
	/**
	 * User registration date.
	 */
	@Column
	private LocalDateTime registrationDate;
	
	/**
	 * UserBookAssociation created by user.
	 */
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
	private Set<BtUserBookAssociation> bookAssociations;
	
}
