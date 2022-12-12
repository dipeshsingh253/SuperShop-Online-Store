package com.supershop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supershop.dto.ProductDto;
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
	public void createProduct(ProductDto productDto) {
		// TODO Auto-generated method stub

		// check if category is valid or not
		Category category = categoryRepository.findById(productDto.getCategoryId()).get();
		Product product = new Product();

		BeanUtils.copyProperties(productDto, product);

		product.setCategory(category);
		productRepository.save(product);

	}

	@Override
	public List<ProductDto> listAllProducts() {

		List<Product> products = productRepository.findAll();

		List<ProductDto> productDtos = new ArrayList<>();

		for (Product product : products) {

			ProductDto productDto = new ProductDto();

			BeanUtils.copyProperties(product, productDto);

			productDto.setCategoryId(product.getCategory().getId());

			productDtos.add(productDto);

		}

		return productDtos;
	}

	@Override
	public void updateProduct(ProductDto productDto) {

		// check if category is valid or not

		Category category = categoryRepository.findById(productDto.getCategoryId()).get();
		Product product = new Product();

		BeanUtils.copyProperties(productDto, product);

		product.setCategory(category);
		productRepository.save(product);

	}

	@Override
	public void removeProduct(Integer productId) {

		Product product = productRepository.findById(productId).get();

		productRepository.delete(product);

	}

}
