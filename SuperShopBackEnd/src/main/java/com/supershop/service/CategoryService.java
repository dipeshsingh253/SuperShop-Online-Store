package com.supershop.service;

import java.util.List;

import com.supershop.model.Category;

public interface CategoryService {

	public void createCategory(Category category);

	public List<Category> listAllCategories();

	public void updateCategory(Category category);

	public void removeCategory(Integer categotyId);

}
