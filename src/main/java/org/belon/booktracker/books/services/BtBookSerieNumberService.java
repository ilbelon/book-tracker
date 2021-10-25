package org.belon.booktracker.books.services;

import java.util.List;

import org.belon.booktracker.books.api.v1.dtos.BtBookSerieNumberDto;

/**
 * Service interface for BtBookSerieNumbers
 * 
 * @author Andrea
 *
 */

public interface BtBookSerieNumberService {

	public BtBookSerieNumberDto createBtBookSerieNumber(BtBookSerieNumberDto serieDto);
	
	public BtBookSerieNumberDto getBtBookSerieNumber(Long id);
	
	public List<BtBookSerieNumberDto> getBtBookSerieNumbersList();
	
	public BtBookSerieNumberDto patchBtBookSerieNumber(BtBookSerieNumberDto serieDto);
	
	public void deleteBtBookSerieNumber(Long id);
}
