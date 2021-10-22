package org.belon.booktracker.books.service.impl;

import java.util.List;
import java.util.Optional;

import org.belon.booktracker.books.api.v1.dtos.BtSettingDto;
import org.belon.booktracker.books.api.v1.mappers.BtSettingMapper;
import org.belon.booktracker.books.entities.BtSetting;
import org.belon.booktracker.books.repositories.BtSettingRepository;
import org.belon.booktracker.books.services.BtSettingService;
import org.belon.booktracker.core.response.exception.customexceptions.ResourceNotFoundException;
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
public class BtSettingServiceImpl implements BtSettingService{

	@Autowired
	private BtSettingRepository settingRepository;
	@Autowired
	private BtSettingMapper settingMapper;
	
	private String settingNotFoundMessage="Setting with this id does not exists";
	
	@Transactional
	public BtSettingDto createBtSetting(BtSettingDto settingDto) {
		BtSetting setting = settingMapper.BtSettingsDtoToBtSettings(settingDto);
//		setting.setRegistrationDate(LocalDateTime.now());
		setting = settingRepository.save(setting);
		return settingMapper.BtSettingsDtoFromBtSettings(setting);
	}

	@Transactional(readOnly = true)
	public BtSettingDto getBtSetting(Long id) {
		Optional<BtSetting> setting = settingRepository.findById(id);
		if(setting.isPresent()) {
			return settingMapper.BtSettingsDtoFromBtSettings(setting.get());
		}
		else throw new ResourceNotFoundException(settingNotFoundMessage);
	}

	@Transactional(readOnly = true)
	public List<BtSettingDto> getBtSettingsList() {
		return settingMapper.BtSettingsDtoFromBtSettings(settingRepository.findAll());
	}

	@Transactional
	public BtSettingDto patchBtSetting(BtSettingDto settingDto) {
		if(settingDto.getId()==null) return null;
		Optional<BtSetting> setting = settingRepository.findById(settingDto.getId());
		if(setting.isPresent()) {
			BtSetting updatedSetting = settingMapper.updateBtSettings(settingDto,setting.get());
			updatedSetting = settingRepository.save(updatedSetting);
			return settingMapper.BtSettingsDtoFromBtSettings(updatedSetting);
		}
		else throw new ResourceNotFoundException(settingNotFoundMessage);
	}

	@Transactional
	public void deleteBtSetting(Long id) {
		try {
			settingRepository.deleteById(id);
		} catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(settingNotFoundMessage);
		}
		
	}

}
