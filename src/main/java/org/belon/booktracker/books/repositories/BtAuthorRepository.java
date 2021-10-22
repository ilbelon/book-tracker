package org.belon.booktracker.books.repositories;

import java.util.Optional;

import org.belon.booktracker.books.entities.BtAuthor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author andrea
 *
 */
public interface BtAuthorRepository extends JpaRepository<BtAuthor, Long>{
	public Optional<BtAuthor> findByNameAndSurname(String name, String surname);
}
