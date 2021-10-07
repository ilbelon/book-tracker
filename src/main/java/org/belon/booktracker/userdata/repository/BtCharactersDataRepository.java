/**
 * 
 */
package org.belon.booktracker.userdata.repository;

import org.belon.booktracker.userdata.entities.BtCharactersData;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author andrea
 *
 */
public interface BtCharactersDataRepository extends JpaRepository<BtCharactersData, Long> {

}
