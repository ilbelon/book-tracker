package org.belon.booktracker.books.repositories;

import java.util.Optional;

import org.belon.booktracker.books.entities.BtBook;
import org.belon.booktracker.books.entities.BtBookSerieNumber;
import org.belon.booktracker.books.entities.BtSerie;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author andrea
 *
 */
public interface BtBookSerieNumberRepository extends JpaRepository<BtBookSerieNumber, Long> {

	Optional<BtBookSerieNumber> findByBookAndSerie(BtBook book, BtSerie serie);
}
