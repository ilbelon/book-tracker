package org.belon.booktracker.books.entities;

import java.io.Serializable;
import java.util.Set;

import lombok.Data;

@Data
public class BtSettings implements Serializable{

	private static final long serialVersionUID = 5401408144750200754L;
	
	private String name;
	
	private Set<BtBooks> books;

}
