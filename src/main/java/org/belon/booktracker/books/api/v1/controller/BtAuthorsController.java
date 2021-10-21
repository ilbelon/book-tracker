package org.belon.booktracker.books.api.v1.controller;

import javax.validation.Valid;

import org.belon.booktracker.books.api.v1.dto.BtAuthorsDto;
import org.belon.booktracker.books.service.BtAuthorsSevice;
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
 * Rest controller for Author
 * 
 * @author Andrea
 *
 */
@RestController
@RequestMapping("/v1/author")
@Api(value="author")
public class BtAuthorsController {

	@Autowired
	private BtAuthorsSevice authorService;
	
	@ApiOperation(value = "Get a list of users")
	@GetMapping(produces = "application/json")
    public ResponseEntity<Object> getAuthorsList(){
        return ResponseFactory.generateResponse("Authors retrieved succesfully", HttpStatus.OK, authorService.getBtAuthorsList());
    }
	
	@ApiOperation(value = "Get the author with given authorId",response = BtAuthorsDto.class)
	@GetMapping(value="/{id}",produces = "application/json")
    public ResponseEntity<Object> getAuthor(@PathVariable(value="id") Long authorId){
		return ResponseFactory.generateResponse("Author retrieved succesfully", HttpStatus.OK, authorService.getBtAuthor(authorId));
    }
	
	@ApiOperation(value = "Create a new author")
	@PostMapping(produces = "application/json")
	public ResponseEntity<Object> createAuthor(@RequestBody @Valid BtAuthorsDto author){
        return ResponseFactory.generateResponse("Author created succesfully", HttpStatus.OK, authorService.createBtAuthor(author));
    }
	
	@ApiOperation(value = "Update an existing author")
	@PatchMapping(produces = "application/json")
	public ResponseEntity<Object> updateAuthor(@RequestBody BtAuthorsDto author){
		return ResponseFactory.generateResponse("Author updated succesfully", HttpStatus.OK, authorService.patchBtAuthor(author));
    }
	
	@ApiOperation(value = "Delete the author with given authorId",response = BtAuthorsDto.class)
	@DeleteMapping(produces = "application/json")
    public ResponseEntity<Object> deleteAuthor(@RequestParam(value="authorId") Long authorId){
        authorService.deleteBtAuthor(authorId);
        return ResponseFactory.generateResponse("Author deleted succesfully", HttpStatus.OK, null);
    }
}