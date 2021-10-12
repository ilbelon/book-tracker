package org.belon.booktracker.books.repositories;

import org.belon.booktracker.books.entities.BtBooks;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author andrea
 *
 */
public interface BtBooksRepository extends JpaRepository<BtBooks, Long>{

}
