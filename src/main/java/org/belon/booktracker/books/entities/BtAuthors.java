package org.belon.booktracker.books.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;

import lombok.Data;

/**
 * Class representing an Author in the application.
 * 
 * @author andrea
 *
 */
//@ApiModel(description = "Class representing an Author in the application.")
@Entity
@Data
public class BtAuthors implements Serializable{

	private static final long serialVersionUID = -1959474518190676963L;
	
	/**
	 * Unique identifier of the author.
	 */
//	@ApiModelProperty(notes = "Unique identifier of the author.", example = "1", required = true, position = 0)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * Name of the Author
	 */
//	@ApiModelProperty(notes = "Name of the Author", example = "Collodi", required = true, position = 1)
	@NotBlank
	@Column
	private String name;
	
	/**
	 * Books written by the Author
	 */
//	@ApiModelProperty(notes = "Books written by the Author", required = false, position = 2, dataType = "BtBooks")
	@ManyToMany(mappedBy = "author", cascade = CascadeType.MERGE)
	private Set<BtBooks> books;
}
