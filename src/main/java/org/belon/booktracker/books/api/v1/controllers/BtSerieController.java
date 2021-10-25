package org.belon.booktracker.books.api.v1.controllers;

import javax.validation.Valid;

import org.belon.booktracker.books.api.v1.dtos.BtSerieDto;
import org.belon.booktracker.books.services.BtSerieService;
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
 * Rest controller for Serie
 * 
 * @author Andrea
 *
 */
@RestController
@RequestMapping("/v1/serie")
@Api(value="Serie")
public class BtSerieController {

	@Autowired
	private BtSerieService SerieService;
	
	@ApiOperation(value = "Get a list of users")
	@GetMapping(produces = "application/json")
    public ResponseEntity<Object> getSeriesList(){
        return ResponseFactory.generateResponse("Series retrieved succesfully", HttpStatus.OK, SerieService.getBtSeriesList());
    }
	
	@ApiOperation(value = "Get the Serie with given SerieId",response = BtSerieDto.class)
	@GetMapping(value="/{id}",produces = "application/json")
    public ResponseEntity<Object> getSerie(@PathVariable(value="id") Long SerieId){
		return ResponseFactory.generateResponse("Serie retrieved succesfully", HttpStatus.OK, SerieService.getBtSerie(SerieId));
    }
	
	@ApiOperation(value = "Create a new Serie")
	@PostMapping(produces = "application/json")
	public ResponseEntity<Object> createSerie(@RequestBody @Valid BtSerieDto Serie){
        return ResponseFactory.generateResponse("Serie created succesfully", HttpStatus.OK, SerieService.createBtSerie(Serie));
    }
	
	@ApiOperation(value = "Update an existing Serie")
	@PatchMapping(produces = "application/json")
	public ResponseEntity<Object> updateSerie(@RequestBody BtSerieDto Serie){
		return ResponseFactory.generateResponse("Serie updated succesfully", HttpStatus.OK, SerieService.patchBtSerie(Serie));
    }
	
	@ApiOperation(value = "Delete the Serie with given SerieId",response = BtSerieDto.class)
	@DeleteMapping(produces = "application/json")
    public ResponseEntity<Object> deleteSerie(@RequestParam(value="SerieId") Long SerieId){
        SerieService.deleteBtSerie(SerieId);
        return ResponseFactory.generateResponse("Serie deleted succesfully", HttpStatus.OK, null);
    }
}
