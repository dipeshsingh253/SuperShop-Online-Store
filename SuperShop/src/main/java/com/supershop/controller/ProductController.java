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
import com.supershop.exception.ProductException;
import com.supershop.exception.UserException;
import com.supershop.model.Product;
import com.supershop.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/products")
	public ResponseEntity<String> createProduct(@RequestParam String token, @RequestBody Product product)
			throws UserException, ProductException, CategoryException {

		productService.createProduct(product, token);

		return new ResponseEntity<String>("Product Created", HttpStatus.ACCEPTED);

	}

	@PutMapping("/products")
	public ResponseEntity<String> updateProduct(@RequestParam String token, @RequestBody Product product)
			throws UserException, ProductException, CategoryException {

		productService.updateProduct(product, token);

		return new ResponseEntity<String>("Product Updated", HttpStatus.ACCEPTED);

	}

	@GetMapping("/products")
	public ResponseEntity<List<Product>> listAllProducts(@RequestParam String token)
			throws UserException, ProductException {

		List<Product> products = productService.listAllPrdoucts(token);

		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);

	}

	@DeleteMapping("/products/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") Integer id, @RequestParam String token)
			throws UserException, ProductException {

		productService.deleteProduct(id, token);

		return new ResponseEntity<String>("Product deleted", HttpStatus.OK);

	}

}
