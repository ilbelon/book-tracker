package org.belon.booktracker.books.entities;

import java.io.Serializable;
import java.util.Set;

import lombok.Data;

@Data
public class BtSeries implements Serializable{

	private static final long serialVersionUID = -1018158729276258248L;
	
	private String name;
	
	private Set<BtBooks> books;

}
