package org.belon.booktracker.userdata.api.v1.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.belon.booktracker.books.api.v1.dtos.BtBookDto;
import org.belon.booktracker.users.api.v1.dtos.BtUserDto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Association Dtoclass between Users and Books.
 * Every data inserted by an user about a book will have a reference to this table.
 * 
 * @author andrea
 *
 */
@Data
public class BtUserBookAssociationDto implements Serializable{

	private static final long serialVersionUID = 1009961008462190649L;
	
	@ApiModelProperty(notes = "User of this association", required = true, position = 0)
	@NotNull(message="User can't be empty")
	private BtUserDto user;
	
	@ApiModelProperty(notes = "Book of this association", required = true, position = 1)
	@NotNull(message="Book can't be empty")
	private BtBookDto book;

}
