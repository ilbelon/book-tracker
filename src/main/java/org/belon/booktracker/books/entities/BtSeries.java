package org.belon.booktracker.books.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import lombok.Data;

/**
 * Class representing a Serie of books
 * 
 * @author andrea
 *
 */
//@ApiModel(description = "Class representing a Serie of books")
@Entity
@Data
public class BtSeries implements Serializable{

	private static final long serialVersionUID = -1018158729276258248L;
	
	/**
	 * Unique identifier of the serie.
	 */
//	@ApiModelProperty(notes = "Unique identifier of the serie.", example = "1", required = true, position = 0)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * Name of the series.
	 */
//	@ApiModelProperty(notes = "Name of the series.", example = "Legend of Drizzt", required = true, position = 1)
	@Column
	@NotBlank
	private String name;
	
	/**
	 * Books in this series.
	 */
//	@ApiModelProperty(notes = "Books in this series.", required = false, position = 2, dataType = "BtBooks")
	@OneToMany(mappedBy = "serie", cascade = CascadeType.REMOVE)
	private Set<BtBookSerieNumber> seriesAssociation;

}
