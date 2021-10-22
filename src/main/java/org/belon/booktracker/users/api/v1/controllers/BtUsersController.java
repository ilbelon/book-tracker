package org.belon.booktracker.users.api.v1.controllers;

import javax.validation.Valid;

import org.belon.booktracker.core.response.ResponseFactory;
import org.belon.booktracker.users.api.v1.dtos.BtUserDto;
import org.belon.booktracker.users.services.BtUserService;
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
 * Rest controller for User
 * 
 * @author Andrea
 *
 */
@RestController
@RequestMapping("/v1/user")
@Api(value="user")
public class BtUsersController {

	@Autowired
	private BtUserService userService;
	
	@ApiOperation(value = "Get a list of users")
	@GetMapping(produces = "application/json")
    public ResponseEntity<Object> getUsersList(){
        return ResponseFactory.generateResponse("Users retrieved succesfully", HttpStatus.OK, userService.getBtUserList());
    }
	
	@ApiOperation(value = "Get the user with given userId",response = BtUserDto.class)
	@GetMapping(value="/{id}",produces = "application/json")
    public ResponseEntity<Object> getUser(@PathVariable(value="id") Long userId){
		return ResponseFactory.generateResponse("User retrieved succesfully", HttpStatus.OK, userService.getBtUser(userId));
    }
	
	@ApiOperation(value = "Create a new user")
	@PostMapping(produces = "application/json")
	public ResponseEntity<Object> createUser(@RequestBody @Valid BtUserDto user){
        return ResponseFactory.generateResponse("User created succesfully", HttpStatus.OK, userService.createBtUser(user));
    }
	
	@ApiOperation(value = "Update an existing user")
	@PatchMapping(produces = "application/json")
	public ResponseEntity<Object> updateUser(@RequestBody BtUserDto user){
		return ResponseFactory.generateResponse("User updated succesfully", HttpStatus.OK, userService.patchBtUser(user));
    }
	
	@ApiOperation(value = "Delete the user with given userId",response = BtUserDto.class)
	@DeleteMapping(produces = "application/json")
    public ResponseEntity<Object> deleteUser(@RequestParam(value="userId") Long userId){
        userService.deleteBtUser(userId);
        return ResponseFactory.generateResponse("User deleted succesfully", HttpStatus.OK, null);
    }
}
