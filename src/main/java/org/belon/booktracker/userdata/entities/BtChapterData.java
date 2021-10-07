package org.belon.booktracker.userdata.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import lombok.Data;

@Data
public class BtChapterData implements Serializable{

	private static final long serialVersionUID = -4906125953485125670L;

	private Long id;
	
	private String title;
	
	private String notes;
	
	private LocalDate insertDate;
	
	private LocalDate updateDate;
	
	private BtUserBookAssociation userBookAssociation;
	
	private Set<BtCharachtersData> connectedCharachters;
	
	private Set<BtPlaceData> connectedPlaces;
}
