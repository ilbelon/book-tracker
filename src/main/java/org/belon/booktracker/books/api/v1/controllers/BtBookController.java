package org.belon.booktracker.books.api.v1.controllers;

import javax.validation.Valid;

import org.belon.booktracker.books.api.v1.dtos.BtBookDto;
import org.belon.booktracker.books.services.BtBookService;
import org.belon.booktracker.core.response.ResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Rest controller for Book
 * 
 * @author Andrea
 *
 */
@RestController
@RequestMapping("/v1/book")
@Api(value="book")
public class BtBookController {

	@Autowired
	private BtBookService bookService;
	
	@ApiOperation(value = "Get a list of books")
	@GetMapping(produces = "application/json")
    public ResponseEntity<Object> getBooksList(){
        return ResponseFactory.generateResponse("Books retrieved succesfully", HttpStatus.OK, bookService.getBtBooksList());
    }
	
	@ApiOperation(value = "Get the book with given bookId",response = BtBookDto.class)
	@GetMapping(value="/{id}",produces = "application/json")
    public ResponseEntity<Object> getBook(@PathVariable(value="id") Long bookId){
		return ResponseFactory.generateResponse("Book retrieved succesfully", HttpStatus.OK, bookService.getBtBook(bookId));
    }
	
	@ApiOperation(value = "Create a new book")
	@PostMapping(produces = "application/json")
	public ResponseEntity<Object> createBook(@RequestBody @Valid BtBookDto book){
        return ResponseFactory.generateResponse("Book created succesfully", HttpStatus.OK, bookService.createBtBook(book));
    }
	
	@ApiOperation(value = "Update an existing book")
	@PatchMapping(produces = "application/json")
	public ResponseEntity<Object> updateBook(@RequestBody BtBookDto book){
		return ResponseFactory.generateResponse("Book updated succesfully", HttpStatus.OK, bookService.patchBtBook(book));
    }
	
	@ApiOperation(value = "Delete the book with given bookId",response = BtBookDto.class)
	@DeleteMapping(produces = "application/json")
    public ResponseEntity<Object> deleteBook(@RequestParam(value="bookId") Long bookId){
        bookService.deleteBtBook(bookId);
        return ResponseFactory.generateResponse("Book deleted succesfully", HttpStatus.OK, null);
    }
}
