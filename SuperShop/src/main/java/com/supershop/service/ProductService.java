package com.supershop.service;

import java.util.List;

import com.supershop.exception.CategoryException;
import com.supershop.exception.ProductException;
import com.supershop.exception.UserException;
import com.supershop.model.Product;

public interface ProductService {

	public void createProduct(Product product, String authenticationToken)
			throws UserException, ProductException, CategoryException;

	public void updateProduct(Product product, String authenticationToken)
			throws UserException, ProductException, CategoryException;

	public List<Product> listAllPrdoucts() throws UserException, ProductException;

	public void deleteProduct(Integer productId, String authenticationToken) throws UserException, ProductException;

	public Product getProductById(Integer id) throws UserException, ProductException;

}
