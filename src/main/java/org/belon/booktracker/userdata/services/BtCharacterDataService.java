package org.belon.booktracker.userdata.services;

import java.util.List;

import org.belon.booktracker.userdata.api.v1.dtos.BtCharacterDataDto;


/**
 * Service interface for BtCharacterDatas
 * 
 * @author Andrea
 *
 */

public interface BtCharacterDataService {

	public BtCharacterDataDto createBtCharacterData(BtCharacterDataDto btCharacterDataDto);
	
	public BtCharacterDataDto getBtCharacterData(Long id);
	
	public List<BtCharacterDataDto> getBtCharacterDatasList();
	
	public BtCharacterDataDto patchBtCharacterData(BtCharacterDataDto btCharacterDataDto);
	
	public void deleteBtCharacterData(Long id);
}
