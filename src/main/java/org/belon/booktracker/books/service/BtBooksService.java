package org.belon.booktracker.books.service;

import java.util.List;

import org.belon.booktracker.books.api.v1.dto.BtBooksDto;

/**
 * Service interface for BtBooks
 * 
 * @author Andrea
 *
 */

public interface BtBooksService {

	public BtBooksDto createBtBook(BtBooksDto bookDto);
	
	public BtBooksDto getBtBook(Long id);
	
	public List<BtBooksDto> getBtBooksList();
	
	public BtBooksDto patchBtBook(BtBooksDto bookDto);
	
	public void deleteBtBook(Long id);
}
