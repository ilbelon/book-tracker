package org.belon.booktracker.books.api.v1.controllers;

import javax.validation.Valid;

import org.belon.booktracker.books.api.v1.dtos.BtSettingDto;
import org.belon.booktracker.books.services.BtSettingService;
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
@RequestMapping("/v1/setting")
@Api(value="setting")
public class BtSettingController {

	@Autowired
	private BtSettingService settingService;
	
	@ApiOperation(value = "Get a list of users")
	@GetMapping(produces = "application/json")
    public ResponseEntity<Object> getSettingsList(){
        return ResponseFactory.generateResponse("Settings retrieved succesfully", HttpStatus.OK, settingService.getBtSettingsList());
    }
	
	@ApiOperation(value = "Get the setting with given settingId",response = BtSettingDto.class)
	@GetMapping(value="/{id}",produces = "application/json")
    public ResponseEntity<Object> getSetting(@PathVariable(value="id") Long settingId){
		return ResponseFactory.generateResponse("Setting retrieved succesfully", HttpStatus.OK, settingService.getBtSetting(settingId));
    }
	
	@ApiOperation(value = "Create a new setting")
	@PostMapping(produces = "application/json")
	public ResponseEntity<Object> createSetting(@RequestBody @Valid BtSettingDto setting){
        return ResponseFactory.generateResponse("Setting created succesfully", HttpStatus.OK, settingService.createBtSetting(setting));
    }
	
	@ApiOperation(value = "Update an existing setting")
	@PatchMapping(produces = "application/json")
	public ResponseEntity<Object> updateSetting(@RequestBody BtSettingDto setting){
		return ResponseFactory.generateResponse("Setting updated succesfully", HttpStatus.OK, settingService.patchBtSetting(setting));
    }
	
	@ApiOperation(value = "Delete the setting with given settingId",response = BtSettingDto.class)
	@DeleteMapping(produces = "application/json")
    public ResponseEntity<Object> deleteSetting(@RequestParam(value="settingId") Long settingId){
        settingService.deleteBtSetting(settingId);
        return ResponseFactory.generateResponse("Setting deleted succesfully", HttpStatus.OK, null);
    }
}
