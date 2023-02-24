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


    @PostMapping("/products")
    public ResponseEntity<String> createProduct(@RequestParam String authenticationToken, @RequestBody Product product)
            throws UserException, ProductException, CategoryException {

        productService.createProduct(product, authenticationToken);

        logger.info("Product Created");

        return new ResponseEntity<>("Product Created", HttpStatus.ACCEPTED);

    }


    // update product
    @PutMapping("/products")
    public ResponseEntity<String> updateProduct(@RequestParam String authenticationToken, @RequestBody Product product)
            throws UserException, ProductException, CategoryException {

        productService.updateProduct(product, authenticationToken);

        logger.info("Product Updated");

        return new ResponseEntity<>("Product Updated", HttpStatus.ACCEPTED);

    }


    @GetMapping("/products")
    public ResponseEntity<List<Product>> listAllProducts()
            throws UserException, ProductException {

        List<Product> products = productService.listAllPrdoucts();

        return new ResponseEntity<>(products, HttpStatus.OK);

    }


    // delete product
    // Note : you can not delete a product if any cart or order have reference to that product in database
    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Integer id, @RequestParam String authenticationToken)
            throws UserException, ProductException {

        productService.deleteProduct(id, authenticationToken);

        logger.warn("Product Deleted");

        return new ResponseEntity<>("Product deleted", HttpStatus.OK);

    }


    // get a single product by product id
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Integer id)
            throws UserException, ProductException {

        Product product = productService.getProductById(id);

        return new ResponseEntity<>(product, HttpStatus.OK);

    }

}
