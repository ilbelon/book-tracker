/**
 * 
 */
package org.belon.booktracker.userdata.repositories;

import org.belon.booktracker.userdata.entities.BtUserBookData;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author andrea
 *
 */
public interface BtUserBookDataRepository extends JpaRepository<BtUserBookData, Long> {

}
