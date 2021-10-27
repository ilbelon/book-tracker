package org.belon.booktracker.userdata.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Class for all places objects created by an user about a book
 * 
 * @author andrea
 *
 */
@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class BtPlacesData extends BtUserBookData implements Serializable {

	private static final long serialVersionUID = 159048470260131438L;

	/**
	 * Place name.
	 */
	@Column
	private String name;
	
	/**
	 * Character born here.
	 */
	@OneToMany(mappedBy = "bornIn", cascade = CascadeType.DETACH,fetch = FetchType.LAZY)
	private Set<BtCharactersData> bornHereCharachters;
	
	/**
	 * Chapter where you find this place.
	 */
	@ManyToMany(mappedBy = "placesInChapter")
	Set<BtChapterData> inChapters;
	
}
