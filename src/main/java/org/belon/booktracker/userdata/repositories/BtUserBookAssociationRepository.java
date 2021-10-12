/**
 * 
 */
package org.belon.booktracker.userdata.repositories;

import org.belon.booktracker.userdata.entities.BtUserBookAssociation;
import org.belon.booktracker.userdata.entities.BtUserBookAssociationId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author andrea
 *
 */
public interface BtUserBookAssociationRepository extends JpaRepository<BtUserBookAssociation, BtUserBookAssociationId> {

}
