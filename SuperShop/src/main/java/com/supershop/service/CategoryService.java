package com.supershop.service;

import java.util.List;

import com.supershop.exception.CategoryException;
import com.supershop.exception.UserException;
import com.supershop.helper.Helper;
import com.supershop.model.Category;

public interface CategoryService {

	public void createCategory(Category category, String authenticationToken) throws CategoryException, UserException;

	public void updateCategory(Category category, String authenticationToken) throws CategoryException, UserException;

	public void deleteCategory(Integer categoryId, String authenticationToken) throws CategoryException, UserException;

	public List<Category> listAllCategories(String authenticationToken) throws CategoryException, UserException;

}
