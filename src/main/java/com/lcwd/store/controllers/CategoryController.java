package com.lcwd.store.controllers;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.store.dtos.ApiResponse;
import com.lcwd.store.dtos.CategoryDto;

import com.lcwd.store.services.CategoryServices;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryServices categoryServices;

	// create
	@PostMapping
	public ResponseEntity<CategoryDto> addEntity(@Valid @RequestBody CategoryDto categoryDto) {
		CategoryDto addCategoryDto = categoryServices.addCategoryDto(categoryDto);
		return new ResponseEntity<CategoryDto>(addCategoryDto, HttpStatus.CREATED);
	}

	// get all
	@GetMapping
	public ResponseEntity<List<CategoryDto>> getAll() {
		List<CategoryDto> allcaCategoryDtos = categoryServices.getAll();
		return ResponseEntity.ok(allcaCategoryDtos);
	}

	// get one
	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable String categoryId) {
		CategoryDto categoryDto = categoryServices.getOne(categoryId);
		return ResponseEntity.ok(categoryDto);
	}

	// update
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> updatEntity(@PathVariable String categoryId,
			@RequestBody CategoryDto categoryDto) {
		CategoryDto categoryDto2 = categoryServices.updateCategoryDto(categoryDto, categoryId);

		return ResponseEntity.ok(categoryDto2);
	}

	// delete
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<ApiResponse> deletEntity(@PathVariable String categoryId) {
		categoryServices.delete(categoryId);
		return new ResponseEntity<ApiResponse>(
				ApiResponse.builder().message("category with id deleted").success(false).build(), HttpStatus.ACCEPTED);

	}

	// search
	@GetMapping("/search/{keywords}")
	public ResponseEntity<List<CategoryDto>> searchEntity(@PathVariable String keywords) {

		return ResponseEntity.ok(categoryServices.searchCategoryDto(keywords));
	}
}
