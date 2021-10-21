package org.belon.booktracker.books.service;

import java.util.List;

import org.belon.booktracker.books.api.v1.dto.BtSettingsDto;

/**
 * Service interface for BtSettings
 * 
 * @author Andrea
 *
 */

public interface BtSettingsService {

	public BtSettingsDto createBtSetting(BtSettingsDto settingDto);
	
	public BtSettingsDto getBtSetting(Long id);
	
	public List<BtSettingsDto> getBtSettingsList();
	
	public BtSettingsDto patchBtSetting(BtSettingsDto settingDto);
	
	public void deleteBtSetting(Long id);
}
