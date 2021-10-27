package org.belon.booktracker.userdata.services.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.belon.booktracker.core.response.exception.customexceptions.PersistenceViolationException;
import org.belon.booktracker.core.response.exception.customexceptions.ResourceNotFoundException;
import org.belon.booktracker.userdata.api.v1.dtos.BtUserBookAssociationDto;
import org.belon.booktracker.userdata.api.v1.dtos.BtUserBookAssociationIdDto;
import org.belon.booktracker.userdata.api.v1.mappers.BtUserBookAssociationIdMapper;
import org.belon.booktracker.userdata.api.v1.mappers.BtUserBookAssociationMapper;
import org.belon.booktracker.userdata.entities.BtUserBookAssociation;
import org.belon.booktracker.userdata.entities.BtUserBookAssociationId;
import org.belon.booktracker.userdata.repositories.BtUserBookAssociationRepository;
import org.belon.booktracker.userdata.services.BtUserBookAssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service implementations for BtUserBookAssociationsService
 * 
 * @userBookAssociation Andrea
 *
 */
@Service
public class BtUserBookAssociationServiceImpl implements BtUserBookAssociationService{

	@Autowired
	private BtUserBookAssociationRepository userBookAssociationRepository;
	@Autowired
	private BtUserBookAssociationMapper userBookAssociationMapper;
	@Autowired
	private BtUserBookAssociationIdMapper userBookAssociationIdMapper;
	
	private String userBookAssociationNotFoundMessage="UserBookAssociation with this id does not exists";
	private String userBookAssociationAlreadyExistsMessage="This user and book combination already exists.";
	
	/**
	 * {@inheritDoc}
	 */
	@Transactional
	public BtUserBookAssociationDto createBtUserBookAssociation(BtUserBookAssociationDto userBookAssociationDto) {
		this.checkIfUserBookAssociationWithNameAndSurnameAlreadyPresent(userBookAssociationDto);
		BtUserBookAssociation userBookAssociation = userBookAssociationMapper.btUserBookAssociationDtoToBtUserBookAssociations(userBookAssociationDto);
		userBookAssociation.setInsertDate(LocalDateTime.now());
		userBookAssociation = userBookAssociationRepository.save(userBookAssociation);
		return userBookAssociationMapper.btUserBookAssociationDtoFromBtUserBookAssociations(userBookAssociation);
	}

	@Transactional(readOnly = true)
	public BtUserBookAssociationDto getBtUserBookAssociation(BtUserBookAssociationIdDto userBookAssociationIdDto) {
		Optional<BtUserBookAssociation> userBookAssociation = userBookAssociationRepository
				.findById(userBookAssociationIdMapper.btUserBookAssociationIdDtoToBtUserBookAssociationId(userBookAssociationIdDto));
		if(userBookAssociation.isPresent()) {
			return userBookAssociationMapper.btUserBookAssociationDtoFromBtUserBookAssociations(userBookAssociation.get());
		}
		else throw new ResourceNotFoundException(userBookAssociationNotFoundMessage);
	}

	@Transactional(readOnly = true)
	public List<BtUserBookAssociationDto> getBtUserBookAssociationList() {
		return userBookAssociationMapper.btUserBookAssociationDtoFromBtUserBookAssociations(userBookAssociationRepository.findAll());
	}

	@Transactional
	public BtUserBookAssociationDto patchBtUserBookAssociation(BtUserBookAssociationDto userBookAssociationDto) {
		this.checkIfUserBookAssociationWithNameAndSurnameAlreadyPresent(userBookAssociationDto);
		Optional<BtUserBookAssociation> userBookAssociation = userBookAssociationRepository.findById(this.idFromDto(userBookAssociationDto));
		if(userBookAssociation.isPresent()) {
			BtUserBookAssociation updateUserBookAssociation = userBookAssociationMapper.updateBtUserBookAssociations(userBookAssociationDto,userBookAssociation.get());
			updateUserBookAssociation = userBookAssociationRepository.save(updateUserBookAssociation);
			return userBookAssociationMapper.btUserBookAssociationDtoFromBtUserBookAssociations(updateUserBookAssociation);
		}
		else throw new ResourceNotFoundException(userBookAssociationNotFoundMessage);
	}

	@Transactional
	public void deleteBtUserBookAssociation(BtUserBookAssociationIdDto userBookAssociationIdDto) {
		try {
			userBookAssociationRepository
			.deleteById(userBookAssociationIdMapper.btUserBookAssociationIdDtoToBtUserBookAssociationId(userBookAssociationIdDto));
		} catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(userBookAssociationNotFoundMessage);
		}
		
	}
	
	private void checkIfUserBookAssociationWithNameAndSurnameAlreadyPresent(BtUserBookAssociationDto userBookAssociationDto) {
		BtUserBookAssociation dtoEntity = userBookAssociationMapper.btUserBookAssociationDtoToBtUserBookAssociations(userBookAssociationDto);
		Optional<BtUserBookAssociation> checkIfAlreadyPresent = userBookAssociationRepository.findByBookAndUser(dtoEntity.getBook(), dtoEntity.getUser());
		if(checkIfAlreadyPresent.isPresent()) throw new PersistenceViolationException(userBookAssociationAlreadyExistsMessage, userBookAssociationMapper.btUserBookAssociationDtoFromBtUserBookAssociations(checkIfAlreadyPresent.get())); 
	}
	
	private BtUserBookAssociationId idFromDto(BtUserBookAssociationDto userBookAssociationDto) {
		BtUserBookAssociationId id = new BtUserBookAssociationId();
		id.setBook(userBookAssociationDto.getBook().getId());
		id.setUser(userBookAssociationDto.getUser().getId());
		return id;
	}
}
