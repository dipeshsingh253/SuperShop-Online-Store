package com.supershop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supershop.exception.CategoryException;
import com.supershop.exception.ProductException;
import com.supershop.model.Category;
import com.supershop.model.Product;
import com.supershop.repository.CategoryRepository;
import com.supershop.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Product addProduct(Product product) throws CategoryException, ProductException {

		Category category = product.getCategory();

		Optional<Category> optionalCategory = categoryRepository.findById(category.getId());

		if (optionalCategory.isEmpty()) {
			throw new ProductException("Category does not exist");
		}

		Optional<Product> optionalProduct = productRepository.findById(product.getId());

		if (!optionalProduct.isEmpty()) {
			throw new ProductException("Product already exist");
		}

		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) throws CategoryException, ProductException {

		Category category = product.getCategory();

		Optional<Category> optionalCategory = categoryRepository.findById(category.getId());

		if (optionalCategory.isEmpty()) {
			throw new ProductException("Category does not exist");
		}
		Optional<Product> optionalProduct = productRepository.findById(product.getId());

		if (optionalProduct.isEmpty()) {
			throw new ProductException("Product does not exist");
		}

		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() throws CategoryException, ProductException {

		List<Product> products = productRepository.findAll();

		if (products.isEmpty()) {
			throw new ProductException("No Products Available");
		}

		return products;
	}

	@Override
	public Product getProductById(Integer id) throws CategoryException, ProductException {

		Optional<Product> optionalProduct = productRepository.findById(id);

		if (optionalProduct.isEmpty()) {
			throw new ProductException("Product does not exist");
		}

		Product product = optionalProduct.get();

		Category category = product.getCategory();

		Optional<Category> optionalCategory = categoryRepository.findById(category.getId());

		if (optionalCategory.isEmpty()) {
			throw new ProductException("Category does not exist");
		}

		return product;
	}

	@Override
	public Product removeProduct(Integer id) throws CategoryException, ProductException {

		Optional<Product> optionalProduct = productRepository.findById(id);

		if (optionalProduct.isEmpty()) {
			throw new ProductException("Product does not exist");
		}

		Product product = optionalProduct.get();

		Category category = product.getCategory();

		Optional<Category> optionalCategory = categoryRepository.findById(category.getId());

		if (optionalCategory.isEmpty()) {
			throw new ProductException("Category does not exist");
		}

		productRepository.delete(product);

		return product;
	}

	@Override
	public String removeAllProducts() throws ProductException {
		productRepository.deleteAll();
		return "All Products removed successfully";
	}

	@Override
	public List<Product> listProductsByCategoryId(Integer categoryId) throws CategoryException, ProductException {

		Optional<Category> optionalCategory = categoryRepository.findById(categoryId);

		if (optionalCategory.isEmpty()) {
			throw new CategoryException("no category available for given id " + categoryId);
		}

		Category category = optionalCategory.get();

		List<Product> products = productRepository.findByCategory(category);

		return products;
	}

}
