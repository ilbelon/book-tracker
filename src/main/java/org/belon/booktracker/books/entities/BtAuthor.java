package org.belon.booktracker.books.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Class representing an Author in the application.
 * 
 * @author andrea
 *
 */
@Entity
@Table(uniqueConstraints=@javax.persistence.UniqueConstraint(columnNames={"name", "surname"}))
@Data
public class BtAuthor implements Serializable{

	private static final long serialVersionUID = -1959474518190676963L;
	
	/**
	 * Unique identifier of the author.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * Name of the Author
	 */
	@NotBlank
	@Column
	@Size(min=3,max=50,message="Name length must be between 3 and 50")
	private String name;
	
	@NotBlank
	@Column
	@Size(min=3,max=50,message="Name length must be between 3 and 50")
	private String surname;
	
	/**
	 * Books written by the Author
	 */
	@EqualsAndHashCode.Exclude
	@ManyToMany(mappedBy="authors")
	private Set<BtBook> books;
}
