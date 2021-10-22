package org.belon.booktracker.books.repositories;

import java.util.Optional;

import org.belon.booktracker.books.entities.BtBook;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author andrea
 *
 */
public interface BtBookRepository extends JpaRepository<BtBook, Long>{

	public Optional<BtBook> findByTitle(String title);
}
