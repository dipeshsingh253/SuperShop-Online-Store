package com.supershop.service;

import java.util.List;

import com.supershop.dto.ProductDto;

public interface ProductService {

	public void createProduct(ProductDto productDto);

	public List<ProductDto> listAllProducts();

	public void updateProduct(ProductDto productDto);

	public void removeProduct(Integer productId);

}
