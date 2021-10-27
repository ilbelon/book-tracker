package org.belon.booktracker.userdata.services.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.belon.booktracker.core.response.exception.customexceptions.PersistenceViolationException;
import org.belon.booktracker.core.response.exception.customexceptions.ResourceNotFoundException;
import org.belon.booktracker.userdata.api.v1.dtos.BtCharacterDataDto;
import org.belon.booktracker.userdata.api.v1.mappers.BtCharacterDataMapper;
import org.belon.booktracker.userdata.entities.BtCharacterData;
import org.belon.booktracker.userdata.repositories.BtCharacterDataRepository;
import org.belon.booktracker.userdata.services.BtCharacterDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service implementations for BtCharacterDatasService
 * 
 * @author Andrea
 *
 */
@Service
public class BtCharacterDataServiceImpl implements BtCharacterDataService{

	@Autowired
	private BtCharacterDataRepository characterDataRepository;
	@Autowired
	private BtCharacterDataMapper characterDataMapper;
	
	private String characterDataNotFoundMessage="CharacterData with this id does not exists";
	private String characterNameAlreadyExistsMessage="Character with this name already exists.";
	
	@Transactional
	public BtCharacterDataDto createBtCharacterData(BtCharacterDataDto characterDataDto) {
		this.checkIfCharacterDataWithNameAlreadyPresent(characterDataDto);
		BtCharacterData characterData = characterDataMapper.btCharacterDataDtoToBtCharacterData(characterDataDto);
		characterData.setInsertDate(LocalDateTime.now());
		characterData = characterDataRepository.save(characterData);
		return characterDataMapper.btCharacterDataDtoFromBtCharacterData(characterData);
	}

	@Transactional(readOnly = true)
	public BtCharacterDataDto getBtCharacterData(Long id) {
		Optional<BtCharacterData> characterData = characterDataRepository.findById(id);
		if(characterData.isPresent()) {
			return characterDataMapper.btCharacterDataDtoFromBtCharacterData(characterData.get());
		}
		else throw new ResourceNotFoundException(characterDataNotFoundMessage);
	}

	@Transactional(readOnly = true)
	public List<BtCharacterDataDto> getBtCharacterDatasList() {
		return characterDataMapper.btCharacterDataDtosFromBtCharacterDatas(characterDataRepository.findAll());
	}

	@Transactional
	public BtCharacterDataDto patchBtCharacterData(BtCharacterDataDto characterDataDto) {
		this.checkIfCharacterDataWithNameAlreadyPresent(characterDataDto);
		Optional<BtCharacterData> characterData = characterDataRepository.findById(characterDataDto.getId());
		if(characterData.isPresent()) {
			BtCharacterData updatedCharacterData = characterDataMapper.updateBtCharacterData(characterDataDto,characterData.get());
			updatedCharacterData.setUpdateDate(LocalDateTime.now());
			updatedCharacterData = characterDataRepository.save(updatedCharacterData);
			return characterDataMapper.btCharacterDataDtoFromBtCharacterData(updatedCharacterData);
		}
		else throw new ResourceNotFoundException(characterDataNotFoundMessage);
	}

	@Transactional
	public void deleteBtCharacterData(Long id) {
		try {
			characterDataRepository.deleteById(id);
		} catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(characterDataNotFoundMessage);
		}
		
	}
	
	private void checkIfCharacterDataWithNameAlreadyPresent(BtCharacterDataDto characterDataDto) {
		BtCharacterData dtoEntity = characterDataMapper.btCharacterDataDtoToBtCharacterData(characterDataDto);
		Optional<BtCharacterData> checkIfTitleAlreadyPresent = 
				characterDataRepository.findByUserBookAssociationAndName(dtoEntity.getUserBookAssociation(), dtoEntity.getName());
		if(checkIfTitleAlreadyPresent.isPresent()&&!checkIfTitleAlreadyPresent.get().getId().equals(characterDataDto.getId())
				) throw new PersistenceViolationException(characterNameAlreadyExistsMessage, characterDataMapper.btCharacterDataDtoFromBtCharacterData(checkIfTitleAlreadyPresent.get()));
	}

}
