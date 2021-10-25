package org.belon.booktracker.books.services;

import java.util.List;

import org.belon.booktracker.books.api.v1.dtos.BtSerieDto;

/**
 * Service interface for BtSeries
 * 
 * @author Andrea
 *
 */

public interface BtSerieService {

	public BtSerieDto createBtSerie(BtSerieDto serieDto);
	
	public BtSerieDto getBtSerie(Long id);
	
	public List<BtSerieDto> getBtSeriesList();
	
	public BtSerieDto patchBtSerie(BtSerieDto serieDto);
	
	public void deleteBtSerie(Long id);
}
