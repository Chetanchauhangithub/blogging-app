package com.codewithchetan.blog.services;

import java.util.List;

import com.codewithchetan.blog.payloads.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto user);
	UserDto getById(Integer userId);
	List<UserDto> getAllUser();
	void deleteUser(Integer userId);
	UserDto updateUser(UserDto user, Integer userId);

}
