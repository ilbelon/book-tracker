package org.belon.booktracker.books.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * Class representing ManyToMany relationship between books and series
 *
 * @author andrea
 *
 */
//@ApiModel(description = "Class representing ManyToMany relationship between books and series")
@Entity
@Table(uniqueConstraints=@javax.persistence.UniqueConstraint(columnNames={"book_id", "serie_id","number_of_this_book_in_series"}))
@Data
public class BtBookSerieNumber implements Serializable {

	private static final long serialVersionUID = -121340344346838183L;

	/**
	 * Unique identifier of the BtBookSerieNumber.
	 */
//	@ApiModelProperty(notes = "Unique identifier of the BtBookSerieNumber.", example = "1", required = true, position = 0)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * Books FK.
	 */
//	@ApiModelProperty(notes = "Books FK.", required = true, position = 0, dataType = "BtBooks")
    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    @NotNull(message="Book can't be null")
    private BtBook book;

	/**
	 * Serie FK.
	 */
//	@ApiModelProperty(notes = "Serie FK.", required = true, position = 1, dataType = "BtSeries")
    @ManyToOne
    @JoinColumn(name = "serie_id", referencedColumnName = "id")
    @NotNull(message="Serie can't be null")
	private BtSerie serie;

	/**
	 * Number representing the order of this book in the series
	 */
//	@ApiModelProperty(notes = "Number representing the order of this book in the series", example = "2", required = true)
	@Column
	@NotNull(message="Number of this book in series can't be null")
	@Min(value=1,message="The book number in serie can't be lesser than 1")
	private int numberOfThisBookInSeries;
}
