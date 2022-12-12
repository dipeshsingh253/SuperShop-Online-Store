package com.supershop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.supershop.model.Category;
import com.supershop.service.CategoryService;

@CrossOrigin("http://localhost:8080/")
@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/categories")
	public String createCategory(@RequestBody Category category) {

		categoryService.createCategory(category);

		return "Category Created";

	}

	@GetMapping("/categories")
	public List<Category> listAllCategories() {

		List<Category> categories = categoryService.listAllCategories();

		return categories;

	}

	@PutMapping("/categories")
	public String updateCategory(@RequestBody Category category) {

		categoryService.updateCategory(category);

		return "Category Updated";

	}

	@DeleteMapping("/categories/{id}")
	public String deleteCategory(@PathVariable("id") Integer categoryId) {

		categoryService.removeCategory(categoryId);

		return "Category Removed";

	}
}
