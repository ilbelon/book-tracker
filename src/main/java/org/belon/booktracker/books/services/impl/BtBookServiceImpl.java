package org.belon.booktracker.books.services.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.belon.booktracker.books.api.v1.dtos.BtBookDto;
import org.belon.booktracker.books.api.v1.mappers.BtBookMapper;
import org.belon.booktracker.books.entities.BtBook;
import org.belon.booktracker.books.repositories.BtBookRepository;
import org.belon.booktracker.books.services.BtBookService;
import org.belon.booktracker.core.response.exception.customexceptions.PersistenceViolationException;
import org.belon.booktracker.core.response.exception.customexceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service implementations for BtBooksService
 * 
 * @author Andrea
 *
 */
@Service
public class BtBookServiceImpl implements BtBookService{

	@Autowired
	private BtBookRepository bookRepository;
	@Autowired
	private BtBookMapper bookMapper;
	
	private String bookNotFoundMessage="Book with this id does not exists";
	private String bookAlreadyExistsMessage="This book already exists.";
	
	@Transactional
	public BtBookDto createBtBook(@Valid BtBookDto bookDto) {
		this.checkIfBookAlreadyPresent(bookDto);
		BtBook book = bookMapper.btBooksDtoToBtBooks(bookDto);
		book = bookRepository.save(book);
		return bookMapper.btBooksDtoFromBtBooks(book);
	}

	@Transactional(readOnly = true)
	public BtBookDto getBtBook(Long id) {
		Optional<BtBook> book = bookRepository.findById(id);
		if(book.isPresent()) {
			return bookMapper.btBooksDtoFromBtBooks(book.get());
		}
		else throw new ResourceNotFoundException(bookNotFoundMessage);
	}

	@Transactional(readOnly = true)
	public List<BtBookDto> getBtBooksList() {
		return bookMapper.btBooksDtoFromBtBooks(bookRepository.findAll());
	}

	@Transactional
	public BtBookDto patchBtBook(BtBookDto bookDto) {
		this.checkIfBookAlreadyPresent(bookDto);
		Optional<BtBook> book = bookRepository.findById(bookDto.getId());
		if(book.isPresent()) {
			BtBook updatedbook = bookMapper.updateBtBooks(bookDto,book.get());
			updatedbook = bookRepository.save(updatedbook);
			return bookMapper.btBooksDtoFromBtBooks(updatedbook);
		}
		else throw new ResourceNotFoundException(bookNotFoundMessage);
	}

	@Transactional
	public void deleteBtBook(Long id) {
		try {
			bookRepository.deleteById(id);
		} catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(bookNotFoundMessage);
		}
	}
	
	private void checkIfBookAlreadyPresent(BtBookDto bookDto) {
		Optional<BtBook> checkIfAlreadyPresent = bookRepository.findByTitle(bookDto.getTitle());
		if(checkIfAlreadyPresent.isPresent()&&!checkIfAlreadyPresent.get().getId().equals(bookDto.getId())) 
			throw new PersistenceViolationException(bookAlreadyExistsMessage, bookMapper.btBooksDtoFromBtBooks(checkIfAlreadyPresent.get())); 
	}
}
