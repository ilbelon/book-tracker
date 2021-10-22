package org.belon.booktracker.books.repositories;

import org.belon.booktracker.books.entities.BtSerie;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author andrea
 *
 */
public interface BtSerieRepository extends JpaRepository<BtSerie, Long> {

}
