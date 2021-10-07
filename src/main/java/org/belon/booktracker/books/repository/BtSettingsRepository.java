package org.belon.booktracker.books.repository;

import org.belon.booktracker.books.entities.BtSettings;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author andrea
 *
 */
public interface BtSettingsRepository extends JpaRepository<BtSettings, Long> {

}
