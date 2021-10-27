package org.belon.booktracker.userdata.api.v1.controllers;

import javax.validation.Valid;

import org.belon.booktracker.core.response.ResponseFactory;
import org.belon.booktracker.userdata.api.v1.dtos.BtChapterDataDto;
import org.belon.booktracker.userdata.services.BtChapterDataService;
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
 * Rest controller for ChapterData
 * 
 * @author Andrea
 *
 */
@RestController
@RequestMapping("/v1/chapterdata")
@Api(value="chapterdata")
public class BtChapterDataController {

	@Autowired
	private BtChapterDataService chapterDtaService;
	
	@ApiOperation(value = "Get a list of chapterDatas")
	@GetMapping(produces = "application/json")
    public ResponseEntity<Object> getChapterDatasList(){
        return ResponseFactory.generateResponse("ChapterDatas retrieved succesfully", HttpStatus.OK, chapterDtaService.getBtChapterDatasList());
    }
	
	@ApiOperation(value = "Get the chapterDta with given chapterDtaId",response = BtChapterDataDto.class)
	@GetMapping(value="/{id}",produces = "application/json")
    public ResponseEntity<Object> getChapterData(@PathVariable(value="id") Long chapterDtaId){
		return ResponseFactory.generateResponse("ChapterData retrieved succesfully", HttpStatus.OK, chapterDtaService.getBtChapterData(chapterDtaId));
    }
	
	@ApiOperation(value = "Create a new chapterDta")
	@PostMapping(produces = "application/json")
	public ResponseEntity<Object> createChapterData(@RequestBody @Valid BtChapterDataDto chapterDta){
        return ResponseFactory.generateResponse("ChapterData created succesfully", HttpStatus.OK, chapterDtaService.createBtChapterData(chapterDta));
    }
	
	@ApiOperation(value = "Update an existing chapterDta")
	@PatchMapping(produces = "application/json")
	public ResponseEntity<Object> updateChapterData(@RequestBody BtChapterDataDto chapterDta){
		return ResponseFactory.generateResponse("ChapterData updated succesfully", HttpStatus.OK, chapterDtaService.patchBtChapterData(chapterDta));
    }
	
	@ApiOperation(value = "Delete the chapterDta with given chapterDtaId",response = BtChapterDataDto.class)
	@DeleteMapping(produces = "application/json")
    public ResponseEntity<Object> deleteChapterData(@RequestParam(value="chapterDtaId") Long chapterDtaId){
        chapterDtaService.deleteBtChapterData(chapterDtaId);
        return ResponseFactory.generateResponse("ChapterData deleted succesfully", HttpStatus.OK, null);
    }
}
