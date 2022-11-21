package com.supershop.service;

import java.util.List;

import com.supershop.exception.CategoryException;
import com.supershop.exception.ProductException;
import com.supershop.model.Product;

public interface ProductService {

	Product addProduct(Product product) throws CategoryException,ProductException;

	Product updateProduct(Product product) throws CategoryException,ProductException;

	List<Product> getAllProducts() throws CategoryException, ProductException;

	Product getProductById(Integer id) throws CategoryException, ProductException;

	Product removeProduct(Integer id) throws CategoryException, ProductException;

	String removeAllProducts() throws ProductException;
	

	
}
