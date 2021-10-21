package org.belon.booktracker.books.repositories;

import java.util.Optional;

import org.belon.booktracker.books.entities.BtAuthors;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author andrea
 *
 */
public interface BtAuthorsRepository extends JpaRepository<BtAuthors, Long>{
	public Optional<BtAuthors> findByNameAndSurname(String name, String surname);
}
