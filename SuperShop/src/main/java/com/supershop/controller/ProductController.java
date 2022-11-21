package com.supershop.controller;

import java.util.List;

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
import com.supershop.model.Product;
import com.supershop.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	
	@PostMapping("/products")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) throws CategoryException, ProductException {

		Product savedProduct = productService.addProduct(product);

		return new ResponseEntity<Product>(savedProduct, HttpStatus.ACCEPTED);

	}

	@PutMapping("/products")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product)
			throws CategoryException, ProductException {

		Product updatedProduct = productService.updateProduct(product);

		return new ResponseEntity<Product>(updatedProduct, HttpStatus.ACCEPTED);

	}

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts() throws CategoryException, ProductException {

		List<Product> products = productService.getAllProducts();

		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);

	}

	@GetMapping("/products/id")
	public ResponseEntity<Product> getProductByid(@RequestParam Integer id) throws CategoryException, ProductException {

		Product product = productService.getProductById(id);

		return new ResponseEntity<Product>(product, HttpStatus.OK);

	}

	@DeleteMapping("/products/id")
	public ResponseEntity<Product> deleteProductById(@RequestParam Integer id)
			throws CategoryException, ProductException {

		Product deletedProduct = productService.removeProduct(id);

		return new ResponseEntity<Product>(deletedProduct, HttpStatus.OK);

	}

	@DeleteMapping("/products")
	public ResponseEntity<String> deleteProducts() throws ProductException {

		String message = productService.removeAllProducts();

		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

}
