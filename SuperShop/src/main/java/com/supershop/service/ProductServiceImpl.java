package com.supershop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supershop.exception.CategoryException;
import com.supershop.exception.ProductException;
import com.supershop.exception.UserException;
import com.supershop.helper.Helper;
import com.supershop.model.Category;
import com.supershop.model.Product;
import com.supershop.repository.CategoryRepository;
import com.supershop.repository.CurrentUserSessionRepository;
import com.supershop.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private CurrentUserSessionRepository currentUserSessionRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void createProduct(Product product, String authenticationToken)
			throws UserException, ProductException, CategoryException {

		if (Helper.isLoggedIn(authenticationToken, currentUserSessionRepository)
				&& Helper.isAdmin(authenticationToken, currentUserSessionRepository)) {

			Category category = categoryRepository.findById(product.getCategory().getId()).get();

			if (category == null) {
				throw new CategoryException("Category does not exist with given id : " + product.getCategory().getId());
			}

			Product existedProduct = productRepository.findByName(product.getName());

			if (existedProduct != null) {
				throw new ProductException("Product already exist");
			}

			productRepository.save(product);

		} else {
			throw new UserException("You don't have access to perform this operation or log in as an admin");
		}

	}

	@Override
	public void updateProduct(Product product, String authenticationToken)
			throws UserException, ProductException, CategoryException {
		if (Helper.isLoggedIn(authenticationToken, currentUserSessionRepository)
				&& Helper.isAdmin(authenticationToken, currentUserSessionRepository)) {

			Category category = categoryRepository.findById(product.getCategory().getId()).get();

			if (category == null) {
				throw new CategoryException("Category does not exist with given id : " + product.getCategory().getId());
			}

			Product existedProduct = productRepository.findById(product.getId()).get();

			if (existedProduct == null) {
				throw new ProductException("Product does not exist");
			}

			productRepository.save(product);

		} else {
			throw new UserException("You don't have access to perform this operation or log in as an admin");
		}
	}

	@Override
	public List<Product> listAllPrdoucts(String authenticationToken) throws ProductException, UserException {
		if (Helper.isLoggedIn(authenticationToken, currentUserSessionRepository)
				&& Helper.isAdmin(authenticationToken, currentUserSessionRepository)) {

			List<Product> products = productRepository.findAll();

			if (products.isEmpty()) {
				throw new ProductException("No products Available");
			}

			return products;

		} else {
			throw new UserException("You don't have access to perform this operation or log in as an admin");
		}
	}

	@Override
	public void deleteProduct(Integer productId, String authenticationToken) throws ProductException, UserException {
		if (Helper.isLoggedIn(authenticationToken, currentUserSessionRepository)
				&& Helper.isAdmin(authenticationToken, currentUserSessionRepository)) {

			Product existedProduct = productRepository.findById(productId).get();

			if (existedProduct == null) {
				throw new ProductException("Product does not exist");
			}

			productRepository.delete(existedProduct);

		} else {
			throw new UserException("You don't have access to perform this operation or log in as an admin");
		}
	}

}
