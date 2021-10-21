package org.belon.booktracker.books.service.impl;

import java.util.List;
import java.util.Optional;

import org.belon.booktracker.books.api.v1.dto.BtSettingsDto;
import org.belon.booktracker.books.api.v1.mapper.BtSettingsMapper;
import org.belon.booktracker.books.entities.BtSettings;
import org.belon.booktracker.books.repositories.BtSettingsRepository;
import org.belon.booktracker.books.service.BtSettingsService;
import org.belon.booktracker.core.response.exception.customexceptions.ResourceNotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service implementations for BtSettingsService
 * 
 * @author Andrea
 *
 */
@Service
public class BtSettingsServiceImpl implements BtSettingsService{

	@Autowired
	private BtSettingsRepository settingRepository;
	@Autowired
	private BtSettingsMapper settingMapper;
	
	private String settingNotFoundMessage="Setting with this id does not exists";
	
	@Transactional
	public BtSettingsDto createBtSetting(BtSettingsDto settingDto) {
		BtSettings setting = settingMapper.BtSettingsDtoToBtSettings(settingDto);
//		setting.setRegistrationDate(LocalDateTime.now());
		setting = settingRepository.save(setting);
		return settingMapper.BtSettingsDtoFromBtSettings(setting);
	}

	@Transactional(readOnly = true)
	public BtSettingsDto getBtSetting(Long id) {
		Optional<BtSettings> setting = settingRepository.findById(id);
		if(setting.isPresent()) {
			return settingMapper.BtSettingsDtoFromBtSettings(setting.get());
		}
		else throw new ResourceNotFoundExceptions(settingNotFoundMessage);
	}

	@Transactional(readOnly = true)
	public List<BtSettingsDto> getBtSettingsList() {
		return settingMapper.BtSettingsDtoFromBtSettings(settingRepository.findAll());
	}

	@Transactional
	public BtSettingsDto patchBtSetting(BtSettingsDto settingDto) {
		if(settingDto.getId()==null) return null;
		Optional<BtSettings> setting = settingRepository.findById(settingDto.getId());
		if(setting.isPresent()) {
			BtSettings updatedSetting = settingMapper.updateBtSettings(settingDto,setting.get());
			updatedSetting = settingRepository.save(updatedSetting);
			return settingMapper.BtSettingsDtoFromBtSettings(updatedSetting);
		}
		else throw new ResourceNotFoundExceptions(settingNotFoundMessage);
	}

	@Transactional
	public void deleteBtSetting(Long id) {
		try {
			settingRepository.deleteById(id);
		} catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundExceptions(settingNotFoundMessage);
		}
		
	}

}
