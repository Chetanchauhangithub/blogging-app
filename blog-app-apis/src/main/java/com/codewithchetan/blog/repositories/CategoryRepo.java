package com.codewithchetan.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithchetan.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
