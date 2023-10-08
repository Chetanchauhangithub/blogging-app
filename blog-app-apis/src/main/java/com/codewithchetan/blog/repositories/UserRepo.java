package com.codewithchetan.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithchetan.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
	

}
