package org.belon.booktracker.userdata.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

import lombok.Data;

/**
 * Superclass for all data type objects created by an user about a book
 * 
 * @author andrea
 *
 */
@MappedSuperclass
@Data
public class BtUserBookData implements Serializable{

	private static final long serialVersionUID = 4062114072417950172L;
	
	/**
	 * Unique identifier of Data object.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * Notes of Data object.
	 */
	@Column
	private String notes;
	
	/**
	 * Insert of Data object.
	 */
	@Column
	private LocalDateTime insertDate;
	
	/**
	 * UpdateDate of Data object.
	 */
	@Column
	private LocalDateTime updateDate;
	
	@ManyToOne
	@JoinColumns({
		  @JoinColumn(name = "book_id", insertable = false, updatable = false, nullable=false),
		  @JoinColumn(name = "user_id", insertable = false, updatable = false, nullable=false)
		})
	@NotBlank(message="UserBook Association can't be empty")
    private BtUserBookAssociation userBookAssociation;
	
}
