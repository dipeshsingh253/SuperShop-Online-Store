package com.supershop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supershop.model.Category;
import com.supershop.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void createCategory(Category category) {

		categoryRepository.save(category);

	}

	@Override
	public List<Category> listAllCategories() {

		List<Category> categories = categoryRepository.findAll();

		return categories;
	}

	@Override
	public void updateCategory(Category category) {

		categoryRepository.save(category);

	}

	@Override
	public void removeCategory(Integer categotyId) {
		// TODO Auto-generated method stub

		// check if valid

		Category category = categoryRepository.findById(categotyId).get();

		categoryRepository.delete(category);

	}

}
