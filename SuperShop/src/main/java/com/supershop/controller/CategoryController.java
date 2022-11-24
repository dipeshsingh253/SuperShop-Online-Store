package com.supershop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.supershop.exception.CategoryException;
import com.supershop.exception.UserException;
import com.supershop.model.Category;
import com.supershop.service.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/categories")
	public ResponseEntity<String> createCategory(@RequestParam String token, @RequestBody Category category)
			throws CategoryException, UserException {

		categoryService.createCategory(category, token);

		return new ResponseEntity<String>("Category Created", HttpStatus.ACCEPTED);

	}

	@PutMapping("/categories")
	public ResponseEntity<String> updateCategory(@RequestParam String token, @RequestBody Category category)
			throws CategoryException, UserException {

		categoryService.updateCategory(category, token);

		return new ResponseEntity<String>("Category Updated", HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/categories/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable("id") Integer id, @RequestParam String token)
			throws CategoryException, UserException {

		categoryService.deleteCategory(id, token);

		return new ResponseEntity<String>("Category Deleted", HttpStatus.OK);

	}

	@GetMapping("categories")
	public ResponseEntity<List<Category>> listAllCategories(@RequestParam String token)
			throws CategoryException, UserException {

		List<Category> categories = categoryService.listAllCategories(token);

		return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
	}

}
