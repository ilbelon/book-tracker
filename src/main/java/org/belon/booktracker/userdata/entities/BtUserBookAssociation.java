package org.belon.booktracker.userdata.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import lombok.Data;

@Data
public class BtUserBookAssociation implements Serializable {

	private static final long serialVersionUID = -4174012762819947897L;

	Long idBook;
	
	Long idUser;
	
	private LocalDate insertDate;
	
	private Set<BtPlaceData> places;
	
	private Set<BtCharachtersData> charachters;
	
	private Set<BtChapterData> chapters;
	
}
