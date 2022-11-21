package com.supershop.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.supershop.exception.CategoryException;
import com.supershop.exception.ProductException;
import com.supershop.exception.UserException;
import com.supershop.model.Category;
import com.supershop.model.Product;
import com.supershop.service.CategoryService;

@RestController
public class CategoriesController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/categories")
	public ResponseEntity<Category> addCategory(@RequestBody Category category)
			throws CategoryException, UserException {

		Category savedCategory = categoryService.addCategory(category);

		return new ResponseEntity<Category>(savedCategory, HttpStatus.ACCEPTED);

	}

	@PutMapping("/categories")
	public ResponseEntity<Category> updateCategory(@RequestBody Category category)
			throws CategoryException, UserException {

		Category updatedCategory = categoryService.updateCategory(category);

		return new ResponseEntity<Category>(updatedCategory, HttpStatus.ACCEPTED);

	}

	@GetMapping("/categories")
	public ResponseEntity<List<Category>> getAllCategory() throws CategoryException, UserException {

		List<Category> categories = categoryService.getAllCategory();

		return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);

	}

	@GetMapping("/categories/id")
	public ResponseEntity<Category> getCategoryById(@RequestParam Integer categoryId)
			throws CategoryException, UserException {

		Category category = categoryService.getCategoryById(categoryId);

		return new ResponseEntity<Category>(category, HttpStatus.OK);

	}

	@GetMapping("/categories/products")
	public ResponseEntity<Set<Product>> getAllProductsBycategory(@RequestParam String categoryName)
			throws CategoryException, ProductException, UserException {

		Set<Product> products = categoryService.getProductsByCategory(categoryName);

		return new ResponseEntity<Set<Product>>(products, HttpStatus.OK);

	}

	@DeleteMapping("/categories/id")
	public ResponseEntity<Category> removeCategoryById(@RequestParam Integer categoryId)
			throws CategoryException, UserException {

		Category category = categoryService.getCategoryById(categoryId);

		return new ResponseEntity<Category>(category, HttpStatus.OK);

	}

	@DeleteMapping("/categories")
	public ResponseEntity<String> removeAllCategories(@RequestParam Integer categoryId)
			throws CategoryException, UserException {

		String message = categoryService.removeAllCategories();

		return new ResponseEntity<String>(message, HttpStatus.OK);

	}

}
