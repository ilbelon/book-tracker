package org.belon.booktracker.books.service;

import java.util.List;

import org.belon.booktracker.books.api.v1.dto.BtAuthorsDto;
import org.belon.booktracker.core.response.exception.customexceptions.PersistenceViolationException;

/**
 * Service interface for BtAuthors
 * 
 * @author Andrea
 *
 */

public interface BtAuthorsSevice {

	/**
	 * Create a new Author on persistence
	 * 
	 * @param authorDto Author received from controller
	 * @return newly created author
	 * @throws PersistenceViolationException if an author with same name/surname combination
	 * exists
	 */
	public BtAuthorsDto createBtAuthor(BtAuthorsDto bookDto);
	
	public BtAuthorsDto getBtAuthor(Long id);
	
	public List<BtAuthorsDto> getBtAuthorsList();
	
	/**
	 * Patch an Author on persistence
	 * 
	 * @param authorDto Author received from controller
	 * @return newly created author
	 * @throws PersistenceViolationException if an author with same name/surname combination
	 * exists.
	 * ResourceNotFoundException if the authorDto.id is not present in persistence
	 */
	public BtAuthorsDto patchBtAuthor(BtAuthorsDto authorDto);
	
	public void deleteBtAuthor(Long id);
}
