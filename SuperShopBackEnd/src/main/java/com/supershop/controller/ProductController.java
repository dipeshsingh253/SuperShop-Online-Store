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

import com.supershop.dto.ProductDto;
import com.supershop.service.ProductService;


@CrossOrigin("http://localhost:8080/")
@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/products")
	public String addProduct(@RequestBody ProductDto productDto) {

		productService.createProduct(productDto);

		return "Product Added";

	}

	@GetMapping("/products")
	public List<ProductDto> allProducts() {

		List<ProductDto> productDtos = productService.listAllProducts();

		return productDtos;

	}

	@PutMapping("/products")
	public String updateProduct(@RequestBody ProductDto productDto) {

		productService.updateProduct(productDto);

		return "Product Updated";

	}

	@DeleteMapping("/products/{id}")
	public String deleteProduct(@PathVariable("id") Integer productId) {

		productService.removeProduct(productId);

		return "Delete Product";

	}

}
