package org.belon.booktracker.books.repositories;

import java.util.List;
import java.util.Optional;

import org.belon.booktracker.books.entities.BtAuthor;
import org.belon.booktracker.books.entities.BtBook;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author andrea
 *
 */
public interface BtBookRepository extends JpaRepository<BtBook, Long>{

	public Optional<BtBook> findByTitle(String title);
	
	public List<BtBook> findByAuthors(BtAuthor authors);
}
