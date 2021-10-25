package org.belon.booktracker.books.api.v1.controllers;

import javax.validation.Valid;

import org.belon.booktracker.books.api.v1.dtos.BtBookSerieNumberDto;
import org.belon.booktracker.books.services.BtBookSerieNumberService;
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
 * Rest controller for Setting
 * 
 * @author Andrea
 *
 */
@RestController
@RequestMapping("/v1/bookserienumber")
@Api(value="bookserienumber")
public class BtBookSerieNumberController {

	@Autowired
	private BtBookSerieNumberService bookserienumberService;
	
	@ApiOperation(value = "Get a list of BookSerieNumbers")
	@GetMapping(produces = "application/json")
    public ResponseEntity<Object> getBookSerieNumberList(){
        return ResponseFactory.generateResponse("BookSerieNumber retrieved succesfully", HttpStatus.OK, bookserienumberService.getBtBookSerieNumbersList());
    }
	
	@ApiOperation(value = "Get the bookserienumber with given bookserienumberId",response = BtBookSerieNumberDto.class)
	@GetMapping(value="/{id}",produces = "application/json")
    public ResponseEntity<Object> getSetting(@PathVariable(value="id") Long bookserienumberId){
		return ResponseFactory.generateResponse("BookSerieNumber retrieved succesfully", HttpStatus.OK, bookserienumberService.getBtBookSerieNumber(bookserienumberId));
    }
	
	@ApiOperation(value = "Create a new bookserienumber")
	@PostMapping(produces = "application/json")
	public ResponseEntity<Object> createSetting(@RequestBody @Valid BtBookSerieNumberDto bookserienumber){
        return ResponseFactory.generateResponse("BookSerieNumber created succesfully", HttpStatus.OK, bookserienumberService.createBtBookSerieNumber(bookserienumber));
    }
	
	@ApiOperation(value = "Update an existing bookserienumber")
	@PatchMapping(produces = "application/json")
	public ResponseEntity<Object> updateSetting(@RequestBody BtBookSerieNumberDto bookserienumber){
		return ResponseFactory.generateResponse("BookSerieNumber updated succesfully", HttpStatus.OK, bookserienumberService.patchBtBookSerieNumber(bookserienumber));
    }
	
	@ApiOperation(value = "Delete the bookserienumber with given bookserienumberId",response = BtBookSerieNumberDto.class)
	@DeleteMapping(produces = "application/json")
    public ResponseEntity<Object> deleteSetting(@RequestParam(value="bookserienumberId") Long bookserienumberId){
        bookserienumberService.deleteBtBookSerieNumber(bookserienumberId);
        return ResponseFactory.generateResponse("BookSerieNumber deleted succesfully", HttpStatus.OK, null);
    }
}
