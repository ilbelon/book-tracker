/**
 * 
 */
package org.belon.booktracker.userdata.repository;

import org.belon.booktracker.userdata.entities.BtChapterData;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author andrea
 *
 */
public interface BtChapterDataRepository extends JpaRepository<BtChapterData, Long> {

}
