/**
 * 
 */
package org.belon.booktracker.userdata.repositories;

import java.util.Optional;

import org.belon.booktracker.userdata.entities.BtChapterData;
import org.belon.booktracker.userdata.entities.BtUserBookAssociation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author andrea
 *
 */
public interface BtChapterDataRepository extends JpaRepository<BtChapterData, Long> {

	Optional<BtChapterData> findByUserBookAssociationAndTitle(BtUserBookAssociation userBookAssociation, String title);
	
	Optional<BtChapterData> findByUserBookAssociationAndChapterNumber(BtUserBookAssociation userBookAssociation, Long chapterNumber);
	
}
