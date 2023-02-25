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
import com.supershop.exception.CategoryException;
import com.supershop.exception.ProductException;
import com.supershop.exception.UserException;
import com.supershop.model.Product;
import com.supershop.service.ProductService;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * RestController for product functioning. 
 */

@CrossOrigin("http://localhost:3000/")
@RestController
public class ProductController {

    private final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    /**
     * Create a new product with provided details.
     * @param authenticationToken User authentication taken unique for every logged-in user
     * @param product new product to be created
     * @return ResponseEntity {@link String} message to be displayed to the user as response
     * @throws UserException if user details are not valid or user unavailable
     * @throws ProductException if product already exist
     * @throws CategoryException if category does not exist
     */
    @PostMapping("/products")
    public ResponseEntity<String> createProduct(@RequestParam String authenticationToken, @RequestBody Product product)
            throws UserException, ProductException, CategoryException {

        logger.info("called createProduct method of ProductService");
        productService.createProduct(product, authenticationToken);
        logger.info("Product Created");

        return new ResponseEntity<>("Product Created", HttpStatus.ACCEPTED);

    }

    /**
     * Update product details.
     * @param authenticationToken User authentication taken unique for every logged-in user
     * @param product product to be updated
     * @return ResponseEntity {@link String} message to be displayed to the user as response
     * @throws UserException if user details are not valid or user unavailable
     * @throws ProductException if product does not exist
     * @throws CategoryException if category does not exist
     */
    @PutMapping("/products")
    public ResponseEntity<String> updateProduct(@RequestParam String authenticationToken, @RequestBody Product product)
            throws UserException, ProductException, CategoryException {

        logger.info("called updateProduct method of ProductService");
        productService.updateProduct(product, authenticationToken);
        logger.info("Product Updated");

        return new ResponseEntity<>("Product Updated", HttpStatus.ACCEPTED);

    }


    /**
     * Fetch all products available in database.
     * @return ResponseEntity {@link List<Product>} to be displayed to the user as response
     * @throws UserException if user details are not valid or user unavailable
     * @throws ProductException if product does not exist
     */
    @GetMapping("/products")
    public ResponseEntity<List<Product>> listAllProducts()
            throws UserException, ProductException {

        logger.info("called listAllProducts method of ProductService");
        List<Product> products = productService.listAllPrdoucts();
        logger.info("All product details fetched successfully");

        return new ResponseEntity<>(products, HttpStatus.OK);

    }


    /**
     * Delete product with provided id. A product can not be deleted if it is associated with any order or cart.
     * @param id product id to be deleted
     * @param authenticationToken User authentication taken unique for every logged-in user
     * @return ResponseEntity {@link String} message to be displayed to the user as response
     * @throws UserException if user details are not valid or user unavailable
     * @throws ProductException if product does not exist
     */
    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Integer id, @RequestParam String authenticationToken)
            throws UserException, ProductException {

        logger.info("called deleteProduct method of ProductService");
        productService.deleteProduct(id, authenticationToken);
        logger.warn("Product Deleted");

        return new ResponseEntity<>("Product deleted", HttpStatus.OK);

    }


    /**
     * Fetch product for given product id.
     * @param id product id to fetch details for.
     * @return ResponseEntity {@link Product} to be displayed to user as response
     * @throws UserException if user details are not valid or user unavailable
     * @throws ProductException if product does not exist
     */
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Integer id)
            throws UserException, ProductException {

        logger.info("called getProductById method of ProductService");
        Product product = productService.getProductById(id);
        logger.info("product details fetched successfully for given product id");

        return new ResponseEntity<>(product, HttpStatus.OK);

    }

}
