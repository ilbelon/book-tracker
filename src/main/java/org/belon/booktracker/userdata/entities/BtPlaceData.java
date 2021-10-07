package org.belon.booktracker.userdata.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import lombok.Data;

@Data
public class BtPlaceData implements Serializable {

	private static final long serialVersionUID = 159048470260131438L;

	private Long id;
	
	private String name;
	
	private String notes;
	
	private LocalDate insertDate;
	
	private LocalDate updateDate;
	
	private Set<BtCharachtersData> bornHereCharachters;
	
	private Set<BtPlaceData> connectedPlaces;
}
