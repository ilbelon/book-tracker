package org.belon.booktracker.books.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.belon.booktracker.userdata.entities.BtUserBookAssociation;

import lombok.Data;

/**
 * Class representing a book in the application.
 * 
 * @author andrea
 *  
 */
@Entity
@Data
public class BtBook implements Serializable {

	private static final long serialVersionUID = 3125821555736931409L;
	
	/**
	 * Unique identifier of the Book.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * Title of the Book.
	 */
	@Column(unique=true)
	@NotBlank(message="Book title can't be empty")
	@Size(min=2,max=254,message="Book title can't be empty")
	private String title;
	
	/**
	 * Authors of the Book.
	 */
	@ManyToMany
	private Set<BtAuthor> authors;
	
	/**
	 * Setting of the book.
	 */
	@ManyToOne
    @JoinColumn(name="setting_id",nullable=true)
    private BtSetting setting;
	
	/**
	 * BtBookSeriesNumber where book is present.
	 */
	@OneToMany(mappedBy = "book")
	private Set<BtBookSerieNumber> bookAssociations;
	
	/**
	 * UserBookAssociation created by user.
	 */
	@OneToMany(mappedBy = "book")
	private Set<BtUserBookAssociation> userBookAssociations;
	
}
