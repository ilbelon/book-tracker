/**
 * 
 */
package org.belon.booktracker.userdata.repositories;

import java.util.Optional;

import org.belon.booktracker.books.entities.BtBook;
import org.belon.booktracker.userdata.entities.BtUserBookAssociation;
import org.belon.booktracker.userdata.entities.BtUserBookAssociationId;
import org.belon.booktracker.users.entities.BtUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author andrea
 *
 */
public interface BtUserBookAssociationRepository extends JpaRepository<BtUserBookAssociation, BtUserBookAssociationId> {

	Optional<BtUserBookAssociation> findByBookAndUser(BtBook book, BtUser user);
}
