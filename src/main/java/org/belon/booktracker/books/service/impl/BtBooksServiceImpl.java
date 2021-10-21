package org.belon.booktracker.books.service.impl;

import java.util.List;
import java.util.Optional;

import org.belon.booktracker.books.api.v1.dto.BtBooksDto;
import org.belon.booktracker.books.api.v1.mapper.BtBooksMapper;
import org.belon.booktracker.books.entities.BtBooks;
import org.belon.booktracker.books.repositories.BtBooksRepository;
import org.belon.booktracker.books.service.BtBooksService;
import org.belon.booktracker.core.response.exception.customexceptions.ResourceNotFoundExceptions;
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
public class BtBooksServiceImpl implements BtBooksService{

	@Autowired
	private BtBooksRepository bookRepository;
	@Autowired
	private BtBooksMapper bookMapper;
	
	private String bookNotFoundMessage="Book with this id does not exists";
	
	@Transactional
	public BtBooksDto createBtBook(BtBooksDto bookDto) {
		BtBooks book = bookMapper.BtBooksDtoToBtBooks(bookDto);
//		book.setRegistrationDate(LocalDateTime.now());
		book = bookRepository.save(book);
		return bookMapper.BtBooksDtoFromBtBooks(book);
	}

	@Transactional(readOnly = true)
	public BtBooksDto getBtBook(Long id) {
		Optional<BtBooks> book = bookRepository.findById(id);
		if(book.isPresent()) {
			return bookMapper.BtBooksDtoFromBtBooks(book.get());
		}
		else throw new ResourceNotFoundExceptions(bookNotFoundMessage);
	}

	@Transactional(readOnly = true)
	public List<BtBooksDto> getBtBooksList() {
		return bookMapper.BtBooksDtoFromBtBooks(bookRepository.findAll());
	}

	@Transactional
	public BtBooksDto patchBtBook(BtBooksDto bookDto) {
		if(bookDto.getId()==null) return null;
		Optional<BtBooks> book = bookRepository.findById(bookDto.getId());
		if(book.isPresent()) {
			BtBooks updatedbook = bookMapper.updateBtBooks(bookDto,book.get());
			updatedbook = bookRepository.save(updatedbook);
			return bookMapper.BtBooksDtoFromBtBooks(updatedbook);
		}
		else throw new ResourceNotFoundExceptions(bookNotFoundMessage);
	}

	@Transactional
	public void deleteBtBook(Long id) {
		try {
			bookRepository.deleteById(id);
		} catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundExceptions(bookNotFoundMessage);
		}
		
	}

}
