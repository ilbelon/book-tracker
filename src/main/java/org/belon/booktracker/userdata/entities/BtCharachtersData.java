package org.belon.booktracker.userdata.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import lombok.Data;

@Data
public class BtCharachtersData implements Serializable {
	
	private static final long serialVersionUID = -2762832848772257247L;

	private Long id;
	
	private String name;
	
	private String notes;
	
	private LocalDate insertDate;
	
	private LocalDate updateDate;
	
	private Set<BtCharachtersData> connectedCharachters; 
}
