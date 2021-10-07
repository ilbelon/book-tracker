package org.belon.booktracker.userdata.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * Class for all charachters objects created by an user about a book
 * 
 * @author andrea
 *
 */
@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class BtGenericData extends BtUserBookData implements Serializable {

	private static final long serialVersionUID = -7183730687303752310L;
	
	/**
	 * Type of data name.
	 */
	@Column
	private String typeOfData;

}
