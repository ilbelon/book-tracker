/**
 * 
 */
package org.belon.booktracker.userdata.repositories;

import java.util.Optional;

import org.belon.booktracker.userdata.entities.BtCharacterData;
import org.belon.booktracker.userdata.entities.BtUserBookAssociation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author andrea
 *
 */
public interface BtCharacterDataRepository extends JpaRepository<BtCharacterData, Long> {

	Optional<BtCharacterData> findByUserBookAssociationAndName(BtUserBookAssociation userBookAssociation, String name);
	
}
