package com.supershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.supershop.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	Category findByName(String name);

}
