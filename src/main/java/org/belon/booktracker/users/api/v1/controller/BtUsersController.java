package org.belon.booktracker.users.api.v1.controller;

import java.util.List;

import javax.validation.Valid;

import org.belon.booktracker.core.response.ResponseFactory;
import org.belon.booktracker.users.api.v1.dto.BtUsersDto;
import org.belon.booktracker.users.service.BtUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v1/user")
@Api(value="user")
public class BtUsersController {

	@Autowired
	private BtUsersService userService;
	
	@ApiOperation(value = "Get a list of users")
	@GetMapping(produces = "application/json")
    public List<BtUsersDto> getUsersList(){
        return userService.getBtUserList();
    }
	
	@ApiOperation(value = "Get the user with given userId",response = BtUsersDto.class)
	@GetMapping(value="/{id}",produces = "application/json")
    public BtUsersDto getUser(@PathVariable(value="id") Long userId){
        return userService.getBtUser(userId);
    }
	
	@ApiOperation(value = "Create a new user")
	@PostMapping(produces = "application/json")
	public ResponseEntity<Object> createUser(@RequestBody @Valid BtUsersDto user){
        return ResponseFactory.generateResponse("User creation succesfull", HttpStatus.OK, userService.createBtUser(user));
    }
	
	@ApiOperation(value = "Update an existing user")
	@PutMapping(produces = "application/json")
	public ResponseEntity<Object> updateUser(@RequestBody BtUsersDto user){
		return ResponseFactory.generateResponse("User update succesfull", HttpStatus.OK, userService.updateBtUser(user));
    }
	
	@ApiOperation(value = "Delete the user with given userId",response = BtUsersDto.class)
	@DeleteMapping(produces = "application/json")
    public ResponseEntity<Object> deleteUser(@RequestParam(value="userId") Long userId){
        userService.deleteBtUser(userId);
        return ResponseFactory.generateResponse("User delete succesfull", HttpStatus.OK, null);
    }
}
