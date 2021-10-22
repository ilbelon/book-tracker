package org.belon.booktracker.books.repositories;

import org.belon.booktracker.books.entities.BtSetting;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author andrea
 *
 */
public interface BtSettingRepository extends JpaRepository<BtSetting, Long> {

}
