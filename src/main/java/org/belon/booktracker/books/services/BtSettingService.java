package org.belon.booktracker.books.services;

import java.util.List;

import org.belon.booktracker.books.api.v1.dtos.BtSettingDto;

/**
 * Service interface for BtSettings
 * 
 * @author Andrea
 *
 */

public interface BtSettingService {

	public BtSettingDto createBtSetting(BtSettingDto settingDto);
	
	public BtSettingDto getBtSetting(Long id);
	
	public List<BtSettingDto> getBtSettingsList();
	
	public BtSettingDto patchBtSetting(BtSettingDto settingDto);
	
	public void deleteBtSetting(Long id);
}
