package com.supershop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supershop.exception.CategoryException;
import com.supershop.exception.ProductException;
import com.supershop.exception.UserException;
import com.supershop.model.Category;
import com.supershop.model.Product;
import com.supershop.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category addCategory(Category category) throws CategoryException, UserException {

		Optional<Category> optional = categoryRepository.findById(category.getId());

		if (!optional.isEmpty()) {
			throw new CategoryException("category already exist");
		}

		return categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Category category) throws CategoryException, UserException {

		Optional<Category> optional = categoryRepository.findById(category.getId());

		if (optional.isEmpty()) {
			throw new CategoryException("category does not exist");
		}

		return categoryRepository.save(category);
	}

	@Override
	public List<Category> getAllCategory() throws CategoryException, UserException {
		List<Category> categories = categoryRepository.findAll();
		if (categories.isEmpty()) {
			throw new CategoryException("No Categories available");
		}

		return categories;
	}

	@Override
	public Category getCategoryById(Integer categoryId) throws CategoryException, UserException {

		Optional<Category> optional = categoryRepository.findById(categoryId);

		if (optional.isEmpty()) {
			throw new CategoryException("category does not exist");
		}

		return optional.get();
	}

	@Override
	public Category removeCategory(Integer categoryId) throws CategoryException, UserException {

		Optional<Category> optional = categoryRepository.findById(categoryId);

		if (optional.isEmpty()) {
			throw new CategoryException("category does not exist");
		}

		Category deletedCategory = optional.get();

		categoryRepository.delete(deletedCategory);

		return deletedCategory;
	}

	@Override
	public String removeAllCategories() throws CategoryException, UserException {

		categoryRepository.deleteAll();

		return "Categories Removed Successfully";
	}

//	@Override
//	public Set<Product> getProductsByCategory(String name) throws CategoryException, ProductException, UserException {
//
//		Category category = categoryRepository.findByName(name);
//
//		if (category == null) {
//			throw new CategoryException("category does not exist with given name : " + name);
//		}
//
////		List<Product> products = new ArrayList<>();
////
////		products.addAll(category.getProducts());
////
////		if (products.isEmpty()) {
////			throw new ProductException("No Products available in category " + name);
////		}
//
//		Set<Product> products = category.getProducts();
//
//		if (products.isEmpty()) {
//			throw new ProductException("No Products available in category " + name);
//		}
//
//		return products;
//	}

}
