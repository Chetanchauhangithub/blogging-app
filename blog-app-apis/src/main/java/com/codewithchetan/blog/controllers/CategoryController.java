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
import com.codewithchetan.blog.payloads.CategoryDto;
import com.codewithchetan.blog.services.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;

	// create
	@PostMapping("/")
	ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {

		CategoryDto createdCategory = this.categoryService.createCategory(categoryDto);

		return new ResponseEntity<CategoryDto>(createdCategory, HttpStatus.CREATED);
	}

	// update
	@PutMapping("/{catId}")
	ResponseEntity<CategoryDto> updateCategory( @Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer catId) {

		CategoryDto updatedCategory = this.categoryService.updateCategory(categoryDto, catId);

		return new ResponseEntity<CategoryDto>(updatedCategory, HttpStatus.OK);
	}
	
	// delete
	@DeleteMapping("/{catId}")
	ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId) {

		this.categoryService.deleteCategory(catId);

		return new ResponseEntity<ApiResponse>(new ApiResponse("Category Deleted Successfully", true), HttpStatus.OK);
	}

	// findbyId
	@GetMapping("/{catId}")
	ResponseEntity<CategoryDto> findById(@PathVariable Integer catId) {

		CategoryDto category = this.categoryService.getCategoryById(catId);

		return new ResponseEntity<CategoryDto>(category, HttpStatus.OK);

	}

	// findAll
	@GetMapping("/")
	ResponseEntity<List<CategoryDto>> findAllCategory() {

		List<CategoryDto> category = this.categoryService.getAllCategory();

		return new ResponseEntity<List<CategoryDto>>(category, HttpStatus.OK);

	}

}
