package org.belon.booktracker.users.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import org.belon.booktracker.userdata.entities.BtUserBookAssociation;

import lombok.Data;

@Data
public class BtUsers implements Serializable{

	private static final long serialVersionUID = -5804607614843445220L;

	private Long id;
	
	private String name;
	
	private String surname;
	
	private String username;
	
	private String email;
	
	private LocalDate registrationDate;
	
	private Set<BtUserBookAssociation> bookAssociation;
	
}
