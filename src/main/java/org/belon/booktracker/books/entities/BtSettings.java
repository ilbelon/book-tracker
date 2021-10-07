package org.belon.booktracker.books.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import lombok.Data;

/**
 * Class representing a Setting where one or more books stories are placed
 * 
 * @author andrea
 *
 */
//@ApiModel(description = "Class representing a Setting where one or more books stories are placed")
@Entity
@Data
public class BtSettings implements Serializable{

	private static final long serialVersionUID = 5401408144750200754L;
	
	/**
	 * Unique identifier of the setting.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * Name of the setting.
	 */
//	@ApiModelProperty(notes = "Name of the setting.", example = "Forgottens Realms", required = true, position = 1)
	@Column
	@NotBlank
	private String name;
	
	/**
	 * Books in this setting.
	 */
//	@ApiModelProperty(notes = "Books in this setting.", required = false, position = 2, dataType = "BtBooks")
	@OneToMany(mappedBy="setting")
	private Set<BtBooks> books;

}
