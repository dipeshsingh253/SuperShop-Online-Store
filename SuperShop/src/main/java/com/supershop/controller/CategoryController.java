package com.supershop.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

/**
 * RestController for Category functioning.
 */

@CrossOrigin("http://localhost:3000/")
@RestController
public class CategoryController {

    private final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    /**
     * Create a new category.
     * @param authenticationToken User authentication taken unique for every logged-in user
     * @param category new category to be created
     * @return ResponseEntity {@link String} message to be displayed to the user as response
     * @throws CategoryException if category already exist
     * @throws UserException if user details are not valid or user unavailable
     */
    @PostMapping("/categories")
    public ResponseEntity<String> createCategory(@RequestParam String authenticationToken, @RequestBody Category category)
            throws CategoryException, UserException {

        categoryService.createCategory(category, authenticationToken);

        logger.info("Category Created");

        return new ResponseEntity<String>("Category Created", HttpStatus.ACCEPTED);

    }


    /**
     * Update category.
     * @param authenticationToken User authentication taken unique for every logged-in user
     * @param category category to be updated
     * @return ResponseEntity {@link String} message to be displayed to the user as response
     * @throws CategoryException if category does not exist
     * @throws UserException if user details are not valid or user unavailable
     */
    @PutMapping("/categories")
    public ResponseEntity<String> updateCategory(@RequestParam String authenticationToken, @RequestBody Category category)
            throws CategoryException, UserException {

        categoryService.updateCategory(category, authenticationToken);

        logger.info("Category Updated");

        return new ResponseEntity<>("Category Updated", HttpStatus.ACCEPTED);

    }


    /**
     * Delete category. A category can not be deleted if any product belong to that category
     * @param id category id to be deleted
     * @param authenticationToken User authentication taken unique for every logged-in user
     * @return ResponseEntity {@link String} message to be displayed to the user as response
     * @throws CategoryException if category does not exist
     * @throws UserException if user details are not valid or user unavailable
     */
    @DeleteMapping("/categories/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Integer id, @RequestParam String authenticationToken)
            throws CategoryException, UserException {

        categoryService.deleteCategory(id, authenticationToken);

        logger.warn("Category Deleted");

        return new ResponseEntity<>("Category Deleted", HttpStatus.OK);

    }

    /**
     * Fetch list of all available categories
     * @param authenticationToken User authentication taken unique for every logged-in user
     * @return ResponseEntity {@link List<Category>} message to be displayed to the user as response
     * @throws CategoryException if category does not exist
     * @throws UserException if user details are not valid or user unavailable
     */
    @GetMapping("/categories")
    public ResponseEntity<List<Category>> listAllCategories(@RequestParam String authenticationToken)
            throws CategoryException, UserException {

        List<Category> categories = categoryService.listAllCategories(authenticationToken);

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

}
