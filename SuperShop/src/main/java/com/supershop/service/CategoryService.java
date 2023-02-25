package com.supershop.service;

import java.util.List;
import com.supershop.exception.CategoryException;
import com.supershop.exception.UserException;
import com.supershop.model.Category;

/**
 * Service for category functioning.
 */

public interface CategoryService {


	/**
	 * Create a new category.
	 * @param authenticationToken User authentication taken unique for every logged-in user
	 * @param category new category to be created
	 * @throws CategoryException if category already exist
	 * @throws UserException if user details are not valid or user unavailable
	 */
	void createCategory(Category category, String authenticationToken) throws CategoryException, UserException;


	/**
	 * Update category.
	 * @param authenticationToken User authentication taken unique for every logged-in user
	 * @param category category to be updated
	 * @throws CategoryException if category does not exist
	 * @throws UserException if user details are not valid or user unavailable
	 */
	void updateCategory(Category category, String authenticationToken) throws CategoryException, UserException;

	/**
	 * Delete category. A category can not be deleted if any product belong to that category
	 * @param categoryId category id to be deleted
	 * @param authenticationToken User authentication taken unique for every logged-in user
	 * @throws CategoryException if category does not exist
	 * @throws UserException if user details are not valid or user unavailable
	 */
	void deleteCategory(Integer categoryId, String authenticationToken) throws CategoryException, UserException;

	/**
	 * Fetch list of all available categories
	 * @param authenticationToken User authentication taken unique for every logged-in user
	 * @return ResponseEntity {@link List<Category>} message to be displayed to the user as response
	 * @throws CategoryException if category does not exist
	 * @throws UserException if user details are not valid or user unavailable
	 */
	List<Category> listAllCategories(String authenticationToken) throws CategoryException, UserException;

}
