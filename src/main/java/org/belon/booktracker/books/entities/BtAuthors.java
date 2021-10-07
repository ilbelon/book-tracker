package org.belon.booktracker.books.entities;

import java.io.Serializable;
import java.util.Set;

import lombok.Data;

@Data
public class BtAuthors implements Serializable{

	private static final long serialVersionUID = -1959474518190676963L;
	
	private Long id;
	
	private String name;
	
	private String surname;
	
	private Set<BtBooks> books;
}
