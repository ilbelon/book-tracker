package org.belon.booktracker.userdata.api.v1.controllers;

import javax.validation.Valid;

import org.belon.booktracker.core.response.ResponseFactory;
import org.belon.booktracker.userdata.api.v1.dtos.BtUserBookAssociationDto;
import org.belon.booktracker.userdata.api.v1.dtos.BtUserBookAssociationIdDto;
import org.belon.booktracker.userdata.services.BtUserBookAssociationService;
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
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Rest controller for BookUserAssociation
 * 
 * @author Andrea
 *
 */
@RestController
@RequestMapping("/v1/userbookassociation")
@Api(value="UserBookAssociation")
public class BtUserBookAssociationController {

	@Autowired
	private BtUserBookAssociationService bookUserAssociationService;
	
	@ApiOperation(value = "Get a list of users")
	@GetMapping(produces = "application/json")
    public ResponseEntity<Object> getBookUserAssociationsList(){
        return ResponseFactory.generateResponse("BookUserAssociations retrieved succesfully", HttpStatus.OK, 
        		bookUserAssociationService.getBtUserBookAssociationList());
    }
	
	@ApiOperation(value = "Get the BookUserAssociation with given BookUserAssociationId",response = BtUserBookAssociationDto.class)
	@GetMapping(value="/{idUser}/{idBook}",produces = "application/json")
    public ResponseEntity<Object> getBookUserAssociation(@PathVariable(value="idUser") Long idUser ,@PathVariable(value="idBook") Long idBook){
		BtUserBookAssociationIdDto dto = new BtUserBookAssociationIdDto();
		dto.setBook(idBook);
		dto.setUser(idUser);
		return ResponseFactory.generateResponse("BookUserAssociation retrieved succesfully", HttpStatus.OK, 
				bookUserAssociationService.getBtUserBookAssociation(dto));
    }
	
	@ApiOperation(value = "Create a new BookUserAssociation")
	@PostMapping(produces = "application/json")
	public ResponseEntity<Object> createBookUserAssociation(@RequestBody @Valid BtUserBookAssociationDto userBookAssociation){
        return ResponseFactory.generateResponse("BookUserAssociation created succesfully", HttpStatus.OK, 
        		bookUserAssociationService.createBtUserBookAssociation(userBookAssociation));
    }
	
	@ApiOperation(value = "Update an existing BookUserAssociation")
	@PatchMapping(produces = "application/json")
	public ResponseEntity<Object> updateBookUserAssociation(@RequestBody BtUserBookAssociationDto userBookAssociation){
		return ResponseFactory.generateResponse("BookUserAssociation updated succesfully", HttpStatus.OK, 
				bookUserAssociationService.patchBtUserBookAssociation(userBookAssociation));
    }
	
	@ApiOperation(value = "Delete the BookUserAssociation with given BookUserAssociationId",response = BtUserBookAssociationDto.class)
	@DeleteMapping(produces = "application/json")
    public ResponseEntity<Object> deleteBookUserAssociation(@RequestBody BtUserBookAssociationIdDto userBookAssociationId){
        bookUserAssociationService.deleteBtUserBookAssociation(userBookAssociationId);
        return ResponseFactory.generateResponse("BookUserAssociation deleted succesfully", HttpStatus.OK, null);
    }
}
