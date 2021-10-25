package org.belon.booktracker.books.services.impl;

import java.util.List;
import java.util.Optional;

import org.belon.booktracker.books.api.v1.dtos.BtAuthorDto;
import org.belon.booktracker.books.api.v1.mappers.BtAuthorMapper;
import org.belon.booktracker.books.entities.BtAuthor;
import org.belon.booktracker.books.repositories.BtAuthorRepository;
import org.belon.booktracker.books.services.BtAuthorSevice;
import org.belon.booktracker.core.response.exception.customexceptions.PersistenceViolationException;
import org.belon.booktracker.core.response.exception.customexceptions.ResourceNotFoundException;
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
public class BtAuthorServiceImpl implements BtAuthorSevice{

	@Autowired
	private BtAuthorRepository authorRepository;
	@Autowired
	private BtAuthorMapper authorMapper;
	
	private String authorNotFoundMessage="Author with this id does not exists";
	private String authorAlreadyExistsMessage="This name and surname combination already exists.";
	
	/**
	 * {@inheritDoc}
	 */
	@Transactional
	public BtAuthorDto createBtAuthor(BtAuthorDto authorDto) {
		this.checkIfAuthorWithNameAndSurnameAlreadyPresent(authorDto);
		BtAuthor author = authorMapper.btAuthorsDtoToBtAuthors(authorDto);
		author = authorRepository.save(author);
		return authorMapper.btAuthorsDtoFromBtAuthors(author);
	}

	@Transactional(readOnly = true)
	public BtAuthorDto getBtAuthor(Long id) {
		Optional<BtAuthor> author = authorRepository.findById(id);
		if(author.isPresent()) {
			author.get().getBooks();
			System.out.println(author.get().getBooks().toString());
			return authorMapper.btAuthorsDtoFromBtAuthors(author.get());
		}
		else throw new ResourceNotFoundException(authorNotFoundMessage);
	}

	@Transactional(readOnly = true)
	public List<BtAuthorDto> getBtAuthorsList() {
		return authorMapper.btAuthorsDtoFromBtAuthors(authorRepository.findAll());
	}

	@Transactional
	public BtAuthorDto patchBtAuthor(BtAuthorDto authorDto) {
		this.checkIfAuthorWithNameAndSurnameAlreadyPresent(authorDto);
		Optional<BtAuthor> author = authorRepository.findById(authorDto.getId());
		if(author.isPresent()) {
			BtAuthor updateAuthor = authorMapper.updateBtAuthors(authorDto,author.get());
			updateAuthor = authorRepository.save(updateAuthor);
			return authorMapper.btAuthorsDtoFromBtAuthors(updateAuthor);
		}
		else throw new ResourceNotFoundException(authorNotFoundMessage);
	}

	@Transactional
	public void deleteBtAuthor(Long id) {
		try {
			authorRepository.deleteById(id);
		} catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(authorNotFoundMessage);
		}
		
	}
	
	private void checkIfAuthorWithNameAndSurnameAlreadyPresent(BtAuthorDto authorDto) {
		Optional<BtAuthor> checkIfAlreadyPresent = authorRepository.findByNameAndSurname(authorDto.getName(), authorDto.getSurname());
		if(checkIfAlreadyPresent.isPresent()) throw new PersistenceViolationException(authorAlreadyExistsMessage, authorMapper.btAuthorsDtoFromBtAuthors(checkIfAlreadyPresent.get())); 
	}

}
