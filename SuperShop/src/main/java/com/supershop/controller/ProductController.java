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

@CrossOrigin("http://localhost:3000/")
@RestController
public class ProductController {

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

	/*

		/products => Post => create a new product
		/products => Put =>  update product
		/products => Get => list all products
		/products/{id} => Delete => delete product
		/products/{id} => Get => get a single product by product id

	 */


    // create a new product
    @PostMapping("/products")
    public ResponseEntity<String> createProduct(@RequestParam String token, @RequestBody Product product)
            throws UserException, ProductException, CategoryException {

        productService.createProduct(product, token);

        logger.info("Product Created");

        return new ResponseEntity<String>("Product Created", HttpStatus.ACCEPTED);

    }


    // update product
    @PutMapping("/products")
    public ResponseEntity<String> updateProduct(@RequestParam String token, @RequestBody Product product)
            throws UserException, ProductException, CategoryException {

        productService.updateProduct(product, token);

        logger.info("Product Updated");

        return new ResponseEntity<String>("Product Updated", HttpStatus.ACCEPTED);

    }


    // list all the available products
    @GetMapping("/products")
    public ResponseEntity<List<Product>> listAllProducts()
            throws UserException, ProductException {

        List<Product> products = productService.listAllPrdoucts();

        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);

    }


    // delete product
    // Note : you can not delete a product if any cart or order have reference to that product in database
    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Integer id, @RequestParam String token)
            throws UserException, ProductException {

        productService.deleteProduct(id, token);

        logger.warn("Product Deleted");

        return new ResponseEntity<String>("Product deleted", HttpStatus.OK);

    }


    // get a single product by product id
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Integer id)
            throws UserException, ProductException {

        Product product = productService.getProductById(id);

        return new ResponseEntity<Product>(product, HttpStatus.OK);

    }

}
