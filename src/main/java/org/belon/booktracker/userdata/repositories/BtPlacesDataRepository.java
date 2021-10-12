package org.belon.booktracker.userdata.repositories;

import org.belon.booktracker.userdata.entities.BtPlacesData;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author andrea
 *
 */
public interface BtPlacesDataRepository extends JpaRepository<BtPlacesData, Long> {

}
