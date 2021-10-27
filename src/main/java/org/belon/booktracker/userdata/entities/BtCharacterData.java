package org.belon.booktracker.userdata.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Class for all characters objects created by an user about a book
 * 
 * @author andrea
 *
 */
@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class BtCharacterData extends BtUserBookData implements Serializable {
	
	private static final long serialVersionUID = -2762832848772257247L;
	
	/**
	 * Character name.
	 */
	@Column
	private String name;
	
	/**
	 * BtCharachtersBond connected to this character.
	 */
	@OneToMany(mappedBy = "character1", cascade = CascadeType.REMOVE)
	private Set<BtCharactersBond> charactherBond1;
	
	/**
	 * BtCharachtersBond connected to this character.
	 */
	@OneToMany(mappedBy = "character2", cascade = CascadeType.REMOVE)
	private Set<BtCharactersBond> charactherBond2;
	
	/**
	 * Place where character born.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "place_id")
	private BtPlacesData bornIn;
	
	/**
	 * Chapter where you find this character.
	 */
	@ManyToMany(mappedBy = "charactersInChapter",cascade = {CascadeType.DETACH}, fetch = FetchType.LAZY)
	Set<BtChapterData> inChapters;
}
