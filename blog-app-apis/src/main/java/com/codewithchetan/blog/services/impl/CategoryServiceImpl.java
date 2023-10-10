package com.codewithchetan.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.codewithchetan.blog.entities.Category;
import com.codewithchetan.blog.exceptions.ResourceNotFoundException;
import com.codewithchetan.blog.payloads.CategoryDto;
import com.codewithchetan.blog.repositories.CategoryRepo;
import com.codewithchetan.blog.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category category= this.modelMapper.map(categoryDto, Category.class);
		
		Category addedCategory = this.categoryRepo.save(category);
		
		return this.modelMapper.map(addedCategory,CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "CategoryId", categoryId));
		
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		
		Category updatedCat= this.categoryRepo.save(category);
		
		return this.modelMapper.map(updatedCat, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {

		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "CategoryId", categoryId));

		this.categoryRepo.delete(cat);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		
		List<Category> categories = this.categoryRepo.findAll();
		List<CategoryDto> catList= categories.stream().map((cat)->this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		return catList;
	}

	@Override
	public CategoryDto getCategoryById(Integer categoryId) {
	
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "categoryId", categoryId));
		
		return this.modelMapper.map(category, CategoryDto.class);
	}

	

}
