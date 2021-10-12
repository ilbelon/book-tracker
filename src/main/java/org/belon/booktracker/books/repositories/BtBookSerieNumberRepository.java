package org.belon.booktracker.books.repositories;

import org.belon.booktracker.books.entities.BtBookSerieNumber;
import org.belon.booktracker.books.entities.BtBookSerieNumberId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author andrea
 *
 */
public interface BtBookSerieNumberRepository extends JpaRepository<BtBookSerieNumber, BtBookSerieNumberId> {

}
