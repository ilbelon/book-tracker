package org.belon.booktracker.books.services.impl;

import java.util.List;
import java.util.Optional;

import org.belon.booktracker.books.api.v1.dtos.BtBookSerieNumberDto;
import org.belon.booktracker.books.api.v1.mappers.BtBookSerieNumberMapper;
import org.belon.booktracker.books.entities.BtBookSerieNumber;
import org.belon.booktracker.books.repositories.BtBookSerieNumberRepository;
import org.belon.booktracker.books.services.BtBookSerieNumberService;
import org.belon.booktracker.core.response.exception.customexceptions.PersistenceViolationException;
import org.belon.booktracker.core.response.exception.customexceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service implementations for BtBookSerieNumbersService
 * 
 * @author Andrea
 *
 */
@Service
public class BtBookSerieNumberServiceImpl implements BtBookSerieNumberService{

	@Autowired
	private BtBookSerieNumberRepository bookSerieNumberRepository;
	@Autowired
	private BtBookSerieNumberMapper bookSerieNumberMapper;
	
	private String bookSerieNumberNotFoundMessage="BookSerieNumber with this id does not exists";
	private String authorAlreadyExistsMessage="This bookSerieNumber already exists.";
	
	@Transactional
	public BtBookSerieNumberDto createBtBookSerieNumber(BtBookSerieNumberDto bookSerieNumberDto) {
		this.checkIfSettingWithNameAlreadyPresent(bookSerieNumberDto);
		BtBookSerieNumber bookSerieNumber = bookSerieNumberMapper.btBookSerieNumberDtoToBtBookSerieNumber(bookSerieNumberDto);
		bookSerieNumber = bookSerieNumberRepository.save(bookSerieNumber);
		return bookSerieNumberMapper.btBookSerieNumberDtoFromBtBookSerieNumber(bookSerieNumber);
	}

	@Transactional(readOnly = true)
	public BtBookSerieNumberDto getBtBookSerieNumber(Long id) {
		Optional<BtBookSerieNumber> bookSerieNumber = bookSerieNumberRepository.findById(id);
		if(bookSerieNumber.isPresent()) {
			return bookSerieNumberMapper.btBookSerieNumberDtoFromBtBookSerieNumber(bookSerieNumber.get());
		}
		else throw new ResourceNotFoundException(bookSerieNumberNotFoundMessage);
	}

	@Transactional(readOnly = true)
	public List<BtBookSerieNumberDto> getBtBookSerieNumbersList() {
		return bookSerieNumberMapper.btBookSerieNumberDtoFromBtBookSerieNumber(bookSerieNumberRepository.findAll());
	}

	@Transactional
	public BtBookSerieNumberDto patchBtBookSerieNumber(BtBookSerieNumberDto bookSerieNumberDto) {
		this.checkIfSettingWithNameAlreadyPresent(bookSerieNumberDto);
		Optional<BtBookSerieNumber> bookSerieNumber = bookSerieNumberRepository.findById(bookSerieNumberDto.getId());
		if(bookSerieNumber.isPresent()) {
			BtBookSerieNumber updatedSetting = bookSerieNumberMapper.updateBtBookSerieNumber(bookSerieNumberDto,bookSerieNumber.get());
			updatedSetting = bookSerieNumberRepository.save(updatedSetting);
			return bookSerieNumberMapper.btBookSerieNumberDtoFromBtBookSerieNumber(updatedSetting);
		}
		else throw new ResourceNotFoundException(bookSerieNumberNotFoundMessage);
	}

	@Transactional
	public void deleteBtBookSerieNumber(Long id) {
		try {
			bookSerieNumberRepository.deleteById(id);
		} catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(bookSerieNumberNotFoundMessage);
		}
		
	}
	
	private void checkIfSettingWithNameAlreadyPresent(BtBookSerieNumberDto bookSerieNumberDto) {
		BtBookSerieNumber dtoEntity = bookSerieNumberMapper.btBookSerieNumberDtoToBtBookSerieNumber(bookSerieNumberDto);
		Optional<BtBookSerieNumber> checkIfAlreadyPresent = bookSerieNumberRepository.findByBookAndSerie(dtoEntity.getBook(),dtoEntity.getSerie());
		if(checkIfAlreadyPresent.isPresent()&&!checkIfAlreadyPresent.get().getId().equals(bookSerieNumberDto.getId())
				) throw new PersistenceViolationException(authorAlreadyExistsMessage, bookSerieNumberMapper.btBookSerieNumberDtoFromBtBookSerieNumber(checkIfAlreadyPresent.get())); 
	}

}
