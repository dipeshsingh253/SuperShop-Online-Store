package com.supershop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supershop.exception.CategoryException;
import com.supershop.exception.UserException;
import com.supershop.helper.Helper;
import com.supershop.model.Category;
import com.supershop.model.CurrentUserSession;
import com.supershop.repository.CategoryRepository;
import com.supershop.repository.CurrentUserSessionRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CurrentUserSessionRepository currentUserSessionRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void createCategory(Category category, String authenticationToken) throws CategoryException, UserException {

		if (Helper.isLoggedIn(authenticationToken, currentUserSessionRepository)
				&& Helper.isAdmin(authenticationToken, currentUserSessionRepository)) {

			Category existedCategory = categoryRepository.findByName(category.getName());

			if (existedCategory != null) {
				throw new CategoryException("Category already exists");
			}

			categoryRepository.save(category);

			System.out.println("Category saved ");

		} else {
			throw new UserException("You are not allowed to perform this operation");
		}

	}

	@Override
	public void updateCategory(Category category, String authenticationToken) throws CategoryException, UserException {
		if (Helper.isLoggedIn(authenticationToken, currentUserSessionRepository)
				&& Helper.isAdmin(authenticationToken, currentUserSessionRepository)) {

			Category existedCategory = categoryRepository.findById(category.getId()).get();

			if (existedCategory == null) {
				throw new CategoryException("Category does not exists");
			}

			categoryRepository.save(category);

			System.out.println("Category updated");

		} else {
			throw new UserException("You are not allowed to perform this operation");
		}

	}

	@Override
	public void deleteCategory(Integer categoryId, String authenticationToken) throws CategoryException, UserException {
		if (Helper.isLoggedIn(authenticationToken, currentUserSessionRepository)
				&& Helper.isAdmin(authenticationToken, currentUserSessionRepository)) {

			Category existedCategory = categoryRepository.findById(categoryId).get();

			if (existedCategory == null) {
				throw new CategoryException("Category does not exists");
			}

			categoryRepository.delete(existedCategory);

			System.out.println("Category deleted");

		} else {
			throw new UserException("You are not allowed to perform this operation");
		}
	}

	@Override
	public List<Category> listAllCategories(String authenticationToken) throws CategoryException, UserException {
		if (Helper.isLoggedIn(authenticationToken, currentUserSessionRepository)
				&& Helper.isAdmin(authenticationToken, currentUserSessionRepository)) {

			List<Category> categories = categoryRepository.findAll();

			if (categories.isEmpty()) {
				throw new CategoryException("No Categories available");
			}

			return categories;

		} else {
			throw new UserException("You are not allowed to perform this operation");
		}
	}

}
