package org.belon.booktracker.books.services;

import java.util.List;

import org.belon.booktracker.books.api.v1.dtos.BtBookDto;

/**
 * Service interface for BtBooks
 * 
 * @author Andrea
 *
 */

public interface BtBookService {

	public BtBookDto createBtBook(BtBookDto bookDto);
	
	public BtBookDto getBtBook(Long id);
	
	public List<BtBookDto> getBtBooksList();
	
	public BtBookDto patchBtBook(BtBookDto bookDto);
	
	public void deleteBtBook(Long id);
}
