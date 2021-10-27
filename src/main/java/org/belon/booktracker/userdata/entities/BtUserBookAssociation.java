package org.belon.booktracker.userdata.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.belon.booktracker.books.entities.BtBook;
import org.belon.booktracker.users.entities.BtUser;

import lombok.Data;

/**
 * Association class between Users and Books.
 * Every data inserted by an user about a book will have a reference to this table.
 * 
 * @author andrea
 *
 */
@Entity
@IdClass(BtUserBookAssociationId.class)
@Data
public class BtUserBookAssociation implements Serializable {

	private static final long serialVersionUID = -4174012762819947897L;

	/**
	 * Book FK
	 */
	@Id
    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
	private BtBook book;
	
	/**
	 * User FK
	 */
	@Id
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
	private BtUser user;
	
	@Column
	private LocalDateTime insertDate;
	
}
