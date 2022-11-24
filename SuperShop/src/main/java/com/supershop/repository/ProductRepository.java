package com.supershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supershop.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	Product findByName(String name);

}
