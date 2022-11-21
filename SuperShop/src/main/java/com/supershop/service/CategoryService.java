package com.supershop.service;

import java.util.List;
import java.util.Set;

import com.supershop.exception.CategoryException;
import com.supershop.exception.ProductException;
import com.supershop.exception.UserException;
import com.supershop.model.Category;
import com.supershop.model.Product;

public interface CategoryService {

	Category addCategory(Category category) throws CategoryException, UserException;

	Category updateCategory(Category category) throws CategoryException, UserException;

	List<Category> getAllCategory() throws CategoryException, UserException;

	Category getCategoryById(Integer categoryId) throws CategoryException, UserException;

	Category removeCategory(Integer categoryId) throws CategoryException, UserException;

	String removeAllCategories() throws CategoryException, UserException;
	
	Set<Product> getProductsByCategory(String name) throws CategoryException, ProductException, UserException;

}
