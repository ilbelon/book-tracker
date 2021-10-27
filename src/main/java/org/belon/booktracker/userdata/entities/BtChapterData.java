package org.belon.booktracker.userdata.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Class for all chapters objects created by an user about a book
 * 
 * @author andrea
 *
 */
@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class BtChapterData extends BtUserBookData implements Serializable{

	private static final long serialVersionUID = -4906125953485125670L;
	
	/**
	 * Chapter title.
	 */
	@Column
	private String title;
	
	/**
	 * Chapter number.
	 */
	@Column
	private Long chapterNumber;
	
	/**
	 * Characters in this chapter.
	 */
	@ManyToMany(cascade = {CascadeType.DETACH}, fetch = FetchType.LAZY)
	@JoinTable(
	  name = "bt_character_chapter", 
	  joinColumns = @JoinColumn(name = "chapter_id"), 
	  inverseJoinColumns = @JoinColumn(name = "character_id"))
	Set<BtCharacterData> charactersInChapter;
	
	/**
	 * Places in this chapter.
	 */
	@ManyToMany(cascade = {CascadeType.DETACH}, fetch = FetchType.LAZY)
	@JoinTable(
	  name = "bt_place_chapter", 
	  joinColumns = @JoinColumn(name = "chapter_id"), 
	  inverseJoinColumns = @JoinColumn(name = "place_id"))
	Set<BtPlacesData> placesInChapter;
	
}
