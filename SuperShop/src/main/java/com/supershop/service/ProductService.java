package com.supershop.service;

import java.util.List;
import com.supershop.exception.CategoryException;
import com.supershop.exception.ProductException;
import com.supershop.exception.UserException;
import com.supershop.model.Product;


/**
 * Service for product functioning.
 */



public interface ProductService {

	/**
	 * Create a new product with provided details.
	 * @param authenticationToken User authentication taken unique for every logged-in user
	 * @param product new product to be created
	 * @throws UserException if user details are not valid or user unavailable
	 * @throws ProductException if product already exist
	 * @throws CategoryException if category does not exist
	 */
	void createProduct(Product product, String authenticationToken)
			throws UserException, ProductException, CategoryException;


	/**
	 * Update product details.
	 * @param authenticationToken User authentication taken unique for every logged-in user
	 * @param product product to be updated
	 * @throws UserException if user details are not valid or user unavailable
	 * @throws ProductException if product does not exist
	 * @throws CategoryException if category does not exist
	 */
	void updateProduct(Product product, String authenticationToken)
			throws UserException, ProductException, CategoryException;

	/**
	 * Fetch all products available in database.
	 * @return ResponseEntity {@link List<Product>} to be displayed to the user as response
	 * @throws UserException if user details are not valid or user unavailable
	 * @throws ProductException if product does not exist
	 */
	List<Product> listAllPrdoucts() throws UserException, ProductException;


	/**
	 * Delete product with provided id. A product can not be deleted if it is associated with any order or cart.
	 * @param productId product id to be deleted
	 * @param authenticationToken User authentication taken unique for every logged-in user
	 * @throws UserException if user details are not valid or user unavailable
	 * @throws ProductException if product does not exist
	 */
	void deleteProduct(Integer productId, String authenticationToken) throws UserException, ProductException;



	/**
	 * Fetch product for given product id.
	 * @param id product id to fetch details for.
	 * @return ResponseEntity {@link Product} to be displayed to user as response
	 * @throws UserException if user details are not valid or user unavailable
	 * @throws ProductException if product does not exist
	 */
	Product getProductById(Integer id) throws UserException, ProductException;

}
