package org.belon.booktracker.books.services;

import java.util.List;

import org.belon.booktracker.books.api.v1.dtos.BtAuthorDto;
import org.belon.booktracker.core.response.exception.customexceptions.PersistenceViolationException;

/**
 * Service interface for BtAuthors
 * 
 * @author Andrea
 *
 */

public interface BtAuthorSevice {

	/**
	 * Create a new Author on persistence
	 * 
	 * @param authorDto Author received from controller
	 * @return newly created author
	 * @throws PersistenceViolationException if an author with same name/surname combination
	 * exists
	 */
	public BtAuthorDto createBtAuthor(BtAuthorDto bookDto);
	
	public BtAuthorDto getBtAuthor(Long id);
	
	public List<BtAuthorDto> getBtAuthorsList();
	
	/**
	 * Patch an Author on persistence
	 * 
	 * @param authorDto Author received from controller
	 * @return newly created author
	 * @throws PersistenceViolationException if an author with same name/surname combination
	 * exists.
	 * ResourceNotFoundException if the authorDto.id is not present in persistence
	 */
	public BtAuthorDto patchBtAuthor(BtAuthorDto authorDto);
	
	public void deleteBtAuthor(Long id);
}
