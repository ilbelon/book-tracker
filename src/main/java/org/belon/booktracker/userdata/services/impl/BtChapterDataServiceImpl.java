package org.belon.booktracker.userdata.services.impl;

import java.util.List;
import java.util.Optional;

import org.belon.booktracker.core.response.exception.customexceptions.PersistenceViolationException;
import org.belon.booktracker.core.response.exception.customexceptions.ResourceNotFoundException;
import org.belon.booktracker.userdata.api.v1.dtos.BtChapterDataDto;
import org.belon.booktracker.userdata.api.v1.mappers.BtChapterDataMapper;
import org.belon.booktracker.userdata.entities.BtChapterData;
import org.belon.booktracker.userdata.repositories.BtChapterDataRepository;
import org.belon.booktracker.userdata.services.BtChapterDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service implementations for BtChapterDatasService
 * 
 * @author Andrea
 *
 */
@Service
public class BtChapterDataServiceImpl implements BtChapterDataService{

	@Autowired
	private BtChapterDataRepository chapterDataRepository;
	@Autowired
	private BtChapterDataMapper chapterDataMapper;
	
	private String chapterDataNotFoundMessage="ChapterData with this id does not exists";
	private String chapterTitleAlreadyExistsMessage="Chapter with this title already exists.";
	private String chapterNumberAlreadyExistsMessage="Chapter with this number already exists.";
	
	@Transactional
	public BtChapterDataDto createBtChapterData(BtChapterDataDto chapterDataDto) {
		this.checkIfChapterDataWithNameAlreadyPresent(chapterDataDto);
		BtChapterData chapterData = chapterDataMapper.btChapterDataDtoToBtChapterData(chapterDataDto);
		chapterData = chapterDataRepository.save(chapterData);
		return chapterDataMapper.btChapterDataDtoFromBtChapterData(chapterData);
	}

	@Transactional(readOnly = true)
	public BtChapterDataDto getBtChapterData(Long id) {
		Optional<BtChapterData> chapterData = chapterDataRepository.findById(id);
		if(chapterData.isPresent()) {
			return chapterDataMapper.btChapterDataDtoFromBtChapterData(chapterData.get());
		}
		else throw new ResourceNotFoundException(chapterDataNotFoundMessage);
	}

	@Transactional(readOnly = true)
	public List<BtChapterDataDto> getBtChapterDatasList() {
		return chapterDataMapper.btChapterDataDtosFromBtChapterDatas(chapterDataRepository.findAll());
	}

	@Transactional
	public BtChapterDataDto patchBtChapterData(BtChapterDataDto chapterDataDto) {
		this.checkIfChapterDataWithNameAlreadyPresent(chapterDataDto);
		Optional<BtChapterData> chapterData = chapterDataRepository.findById(chapterDataDto.getId());
		if(chapterData.isPresent()) {
			BtChapterData updatedChapterData = chapterDataMapper.updateBtChapterData(chapterDataDto,chapterData.get());
			updatedChapterData = chapterDataRepository.save(updatedChapterData);
			return chapterDataMapper.btChapterDataDtoFromBtChapterData(updatedChapterData);
		}
		else throw new ResourceNotFoundException(chapterDataNotFoundMessage);
	}

	@Transactional
	public void deleteBtChapterData(Long id) {
		try {
			chapterDataRepository.deleteById(id);
		} catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(chapterDataNotFoundMessage);
		}
		
	}
	
	private void checkIfChapterDataWithNameAlreadyPresent(BtChapterDataDto chapterDataDto) {
		BtChapterData dtoEntity = chapterDataMapper.btChapterDataDtoToBtChapterData(chapterDataDto);
		Optional<BtChapterData> checkIfTitleAlreadyPresent = 
				chapterDataRepository.findByUserBookAssociationAndTitle(dtoEntity.getUserBookAssociation(), dtoEntity.getTitle());
		if(checkIfTitleAlreadyPresent.isPresent()&&!checkIfTitleAlreadyPresent.get().getId().equals(chapterDataDto.getId())
				) throw new PersistenceViolationException(chapterTitleAlreadyExistsMessage, chapterDataMapper.btChapterDataDtoFromBtChapterData(checkIfTitleAlreadyPresent.get()));
		Optional<BtChapterData> checkIfChapterNumberAlreadyPresent = 
				chapterDataRepository.findByUserBookAssociationAndChapterNumber(dtoEntity.getUserBookAssociation(), dtoEntity.getChapterNumber());
		if(checkIfChapterNumberAlreadyPresent.isPresent()&&!checkIfChapterNumberAlreadyPresent.get().getId().equals(chapterDataDto.getId())
				) throw new PersistenceViolationException(chapterNumberAlreadyExistsMessage, chapterDataMapper.btChapterDataDtoFromBtChapterData(checkIfChapterNumberAlreadyPresent.get()));
	}

}
