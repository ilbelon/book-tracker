package org.belon.booktracker.userdata.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

/**
 * Association class between Characters.
 * Every data inserted by an user about Characters bonds;
 * 
 * @author andrea
 *
 */
@Entity
@IdClass(BtCharactersBondId.class)
@Data
public class BtCharactersBond implements Serializable {


	private static final long serialVersionUID = -8477086413712810826L;

	/**
	 * first_character_id
	 */
	@Id
    @ManyToOne
    @JoinColumn(name = "character1_id", referencedColumnName = "id")
	private BtCharactersData character1;
	
	/**
	 * second_character_id
	 */
	@Id
    @ManyToOne
    @JoinColumn(name = "character2_id", referencedColumnName = "id")
	private BtCharactersData character2;
	
	@Column
	private String bond;
	
	
	
}
