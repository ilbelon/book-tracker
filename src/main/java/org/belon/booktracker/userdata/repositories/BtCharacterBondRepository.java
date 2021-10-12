package org.belon.booktracker.userdata.repositories;

import org.belon.booktracker.userdata.entities.BtCharactersBond;
import org.belon.booktracker.userdata.entities.BtCharactersBondId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author andrea
 *
 */
public interface BtCharacterBondRepository extends JpaRepository<BtCharactersBond, BtCharactersBondId> {

}
