package org.belon.booktracker.userdata.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.Data;

/**
 * Superclass Dto for all data type objects created by an user about a book
 * 
 * @author andrea
 *
 */
@Data
public class BtUserBookDataDto implements Serializable{

	private static final long serialVersionUID = 6356900624004542287L;

	private Long id;
	
	private String notes;
	
	@NotBlank(message="UserBook Association can't be empty")
    private BtUserBookAssociationDto userBookAssociation;
}
