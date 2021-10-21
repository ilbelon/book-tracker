package org.belon.booktracker.books.service.impl;

import java.util.List;
import java.util.Optional;

import org.belon.booktracker.books.api.v1.dto.BtAuthorsDto;
import org.belon.booktracker.books.api.v1.mapper.BtAuthorsMapper;
import org.belon.booktracker.books.entities.BtAuthors;
import org.belon.booktracker.books.repositories.BtAuthorsRepository;
import org.belon.booktracker.books.service.BtAuthorsSevice;
import org.belon.booktracker.core.response.exception.customexceptions.PersistenceViolationException;
import org.belon.booktracker.core.response.exception.customexceptions.ResourceNotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service implementations for BtAuthorsService
 * 
 * @author Andrea
 *
 */
@Service
public class BtAuthorsServiceImpl implements BtAuthorsSevice{

	@Autowired
	private BtAuthorsRepository authorRepository;
	@Autowired
	private BtAuthorsMapper authorMapper;
	
	private String authorNotFoundMessage="Author with this id does not exists";
	private String authorAlreadyExistsMessage="This name and surname combination already exists.";
	
	/**
	 * @inheritDoc
	 */
	@Transactional
	public BtAuthorsDto createBtAuthor(BtAuthorsDto authorDto) {
		this.checkIfAuthorWithNameAndSurnameAlreadyPresent(authorDto);
		BtAuthors author = authorMapper.BtAuthorsDtoToBtAuthors(authorDto);
		author = authorRepository.save(author);
		return authorMapper.BtAuthorsDtoFromBtAuthors(author);
	}

	@Transactional(readOnly = true)
	public BtAuthorsDto getBtAuthor(Long id) {
		Optional<BtAuthors> author = authorRepository.findById(id);
		if(author.isPresent()) {
			return authorMapper.BtAuthorsDtoFromBtAuthors(author.get());
		}
		else throw new ResourceNotFoundExceptions(authorNotFoundMessage);
	}

	@Transactional(readOnly = true)
	public List<BtAuthorsDto> getBtAuthorsList() {
		return authorMapper.BtAuthorsDtoFromBtAuthors(authorRepository.findAll());
	}

	@Transactional
	public BtAuthorsDto patchBtAuthor(BtAuthorsDto authorDto) {
		this.checkIfAuthorWithNameAndSurnameAlreadyPresent(authorDto);
		Optional<BtAuthors> author = authorRepository.findById(authorDto.getId());
		if(author.isPresent()) {
			BtAuthors updateAuthor = authorMapper.updateBtAuthors(authorDto,author.get());
			updateAuthor = authorRepository.save(updateAuthor);
			return authorMapper.BtAuthorsDtoFromBtAuthors(updateAuthor);
		}
		else throw new ResourceNotFoundExceptions(authorNotFoundMessage);
	}

	@Transactional
	public void deleteBtAuthor(Long id) {
		try {
			authorRepository.deleteById(id);
		} catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundExceptions(authorNotFoundMessage);
		}
		
	}
	
	private void checkIfAuthorWithNameAndSurnameAlreadyPresent(BtAuthorsDto authorDto) {
		Optional<BtAuthors> checkIfAlreadyPresent = authorRepository.findByNameAndSurname(authorDto.getName(), authorDto.getSurname());
		if(checkIfAlreadyPresent.isPresent()) throw new PersistenceViolationException(authorAlreadyExistsMessage, authorMapper.BtAuthorsDtoFromBtAuthors(checkIfAlreadyPresent.get())); 
	}

}
