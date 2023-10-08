package com.codewithchetan.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithchetan.blog.payloads.ApiResponse;
import com.codewithchetan.blog.payloads.UserDto;
import com.codewithchetan.blog.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	//Post Create User
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
		
		UserDto createdUserDto = userService.createUser(userDto);		
		return new ResponseEntity<>(createdUserDto,HttpStatus.CREATED);
	}
	
	
	//PUT Update user
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto usr,@PathVariable("userId") Integer usrId){
		
		UserDto user = this.userService.updateUser(usr, usrId);		
		return ResponseEntity.ok(user);
	}
	
	//Delete User
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId){
		
		this.userService.deleteUser(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully",true),HttpStatus.OK);
		
	}
	
	//Get Fetch All Users
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		
		List<UserDto> users = this.userService.getAllUser();		
		return ResponseEntity.ok(users);
	}
	
	//Get Fetch User by id
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUsersById(@PathVariable Integer userId){
		
		UserDto user = this.userService.getById(userId);		
		return ResponseEntity.ok(user);
	}
	
	
	

}
