package org.belon.booktracker.books.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import lombok.Data;

/**
 * Class representing a book in the application.
 * 
 * @author andrea
 *  
 */
//@ApiModel(description = "Class representing a Book in the application.")
@Entity
@Data
public class BtBooks implements Serializable {

	private static final long serialVersionUID = 3125821555736931409L;
	
	/**
	 * Unique identifier of the Book.
	 */
//	@ApiModelProperty(notes = "Unique identifier of the Book.", example = "1", required = true, position = 0)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * Title of the Book.
	 */
//	@ApiModelProperty(notes = "Title of the Book.", example = "Pinocchio", required = true, position = 1)
	@NotBlank
	@Column
	private String title;
	
	/**
	 * Authors of the Book.
	 */
//	@ApiModelProperty(notes = "Authors of the Book.", required = true, position = 2, dataType = "BtAuthors")
	@NotBlank
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(
			name = "bt_book_author",
			joinColumns = { @JoinColumn(name = "bt_book_id") }, 
			inverseJoinColumns = {@JoinColumn(name = "bt_author_id") }
			)
	private Set<BtAuthors> author;
	
	/**
	 * Setting of the book
	 */
	@ManyToOne
    @JoinColumn(name="setting_id", nullable=false)
    private BtSettings setting;
	
	@OneToMany(mappedBy = "book")
	private Set<BtBookSeriesOrder> bookAssociation;
	
}
