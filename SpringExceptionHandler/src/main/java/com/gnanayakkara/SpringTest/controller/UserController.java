package com.gnanayakkara.SpringTest.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gnanayakkara.SpringTest.Exception.UserNotFoundException;
import com.gnanayakkara.SpringTest.dto.UserRequest;
import com.gnanayakkara.SpringTest.entity.User;
import com.gnanayakkara.SpringTest.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/*
 * 7 Oct 2022
 */
@RestController
@RequestMapping("/users")
public class UserController {
	
	Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired 
	private UserService userService;
	
	@PostMapping("/signup")
	@ApiOperation(value ="Save user details in H2 DB",
			notes = "Save User object with user details",
			response = User.class
			)
	public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest){
		logger.info("SaveUserMethod accessed");
		return new ResponseEntity<>(userService.saveUser(userRequest),HttpStatus.CREATED);
	}
	
	@GetMapping("/fetchAll")
	public ResponseEntity<List<User>> getAllUsers(){
		return ResponseEntity.ok(userService.getAllUsers());
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value ="Find user details by User Id",
		notes = "Provide an Id to get specific User details from the H2 DB",
		response = User.class
		)
	public ResponseEntity<User> getUser(@ApiParam(value="ID value for the User you need to retrieve",required = true)
										@PathVariable int id) throws UserNotFoundException{
		return ResponseEntity.ok(userService.getUser(id));
	}
}
