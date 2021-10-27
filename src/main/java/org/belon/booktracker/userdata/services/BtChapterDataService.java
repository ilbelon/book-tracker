package org.belon.booktracker.userdata.services;

import java.util.List;

import org.belon.booktracker.userdata.api.v1.dtos.BtChapterDataDto;


/**
 * Service interface for BtChapterDatas
 * 
 * @author Andrea
 *
 */

public interface BtChapterDataService {

	public BtChapterDataDto createBtChapterData(BtChapterDataDto btChapterDataDto);
	
	public BtChapterDataDto getBtChapterData(Long id);
	
	public List<BtChapterDataDto> getBtChapterDatasList();
	
	public BtChapterDataDto patchBtChapterData(BtChapterDataDto btChapterDataDto);
	
	public void deleteBtChapterData(Long id);
}
