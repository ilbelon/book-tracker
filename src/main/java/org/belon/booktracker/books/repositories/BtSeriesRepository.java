package org.belon.booktracker.books.repositories;

import org.belon.booktracker.books.entities.BtSeries;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author andrea
 *
 */
public interface BtSeriesRepository extends JpaRepository<BtSeries, Long> {

}
