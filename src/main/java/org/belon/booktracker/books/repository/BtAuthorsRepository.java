package org.belon.booktracker.books.repository;

import org.belon.booktracker.books.entities.BtAuthors;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author andrea
 *
 */
public interface BtAuthorsRepository extends JpaRepository<BtAuthors, Long>{
	
}
