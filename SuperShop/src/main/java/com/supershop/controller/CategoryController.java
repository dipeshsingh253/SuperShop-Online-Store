package com.supershop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.supershop.exception.CategoryException;
import com.supershop.exception.UserException;
import com.supershop.model.Category;
import com.supershop.service.CategoryService;

@CrossOrigin("http://localhost:3000/")
@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
/*
    /categories => Post => create a new category
    /categories => Put => update category
    /categories/{id} => Delete  => delete category
    /categories => Get => get list of all categories
 */

    // create a new category
    @PostMapping("/categories")
    public ResponseEntity<String> createCategory(@RequestParam String token, @RequestBody Category category)
            throws CategoryException, UserException {

        categoryService.createCategory(category, token);

        return new ResponseEntity<String>("Category Created", HttpStatus.ACCEPTED);

    }


    // update category
    @PutMapping("/categories")
    public ResponseEntity<String> updateCategory(@RequestParam String token, @RequestBody Category category)
            throws CategoryException, UserException {

        categoryService.updateCategory(category, token);

        return new ResponseEntity<String>("Category Updated", HttpStatus.ACCEPTED);

    }


    // delete category
    // Note : you can not delete a category if any product have reference to that category in product table
    @DeleteMapping("/categories/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Integer id, @RequestParam String token)
            throws CategoryException, UserException {

        categoryService.deleteCategory(id, token);

        return new ResponseEntity<String>("Category Deleted", HttpStatus.OK);

    }

    // get list of all categories
    @GetMapping("/categories")
    public ResponseEntity<List<Category>> listAllCategories(@RequestParam String token)
            throws CategoryException, UserException {

        List<Category> categories = categoryService.listAllCategories(token);

        return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
    }

}
