/**
 * 
 */
package org.belon.booktracker.userdata.repository;

import org.belon.booktracker.userdata.entities.BtGenericData;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author andrea
 *
 */
public interface BtGenericDataRepository extends JpaRepository<BtGenericData, Long> {

}
