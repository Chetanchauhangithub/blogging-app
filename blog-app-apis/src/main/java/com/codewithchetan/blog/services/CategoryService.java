package com.codewithchetan.blog.services;

import java.util.List;

import com.codewithchetan.blog.payloads.CategoryDto;

public interface CategoryService {

	//create
	CategoryDto createCategory(CategoryDto categoryDto);
	
	//update
	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
	
	//Delete
	public void deleteCategory(Integer categoryId);
	
	//getAllCategory
	List<CategoryDto> getAllCategory();
	
	//getById
	CategoryDto getCategoryById(Integer categoryId);
}
