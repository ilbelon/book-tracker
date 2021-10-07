package org.belon.booktracker.books.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import lombok.Data;

/**
 * Class representing ManyToMany relationship between books and series
 * 
 * @author andrea
 *
 */
//@ApiModel(description = "Class representing ManyToMany relationship between books and series")
@Entity
@IdClass(BtBookSerieNumberId.class)
@Data
public class BtBookSerieNumber implements Serializable {

	private static final long serialVersionUID = -121340344346838183L;
	
	/**
	 * Books FK.
	 */
//	@ApiModelProperty(notes = "Books FK.", required = true, position = 0, dataType = "BtBooks")
	@Id
    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
	private BtBooks book;
	
	/**
	 * Serie FK.
	 */
//	@ApiModelProperty(notes = "Serie FK.", required = true, position = 1, dataType = "BtSeries")
	@Id
    @ManyToOne
    @JoinColumn(name = "serie_id", referencedColumnName = "id")
	private BtSeries serie;
	
	/**
	 * Number representing the order of this book in the series
	 */
//	@ApiModelProperty(notes = "Number representing the order of this book in the series", example = "2", required = true)
	@Column
	@NotBlank
	private int numberOfBookInSeries;
}
