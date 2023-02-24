package com.supershop.controller;

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
import com.supershop.dto.AddItemToCartDto;
import com.supershop.dto.CartDto;
import com.supershop.dto.CartItemDto;
import com.supershop.exception.CartException;
import com.supershop.exception.CurrentUserServiceException;
import com.supershop.exception.ProductException;
import com.supershop.exception.UserException;
import com.supershop.service.CartService;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * RestController for Cart functioning.
 */

@CrossOrigin("http://localhost:3000/")
@RestController
public class CartController {

    private final Logger logger = LoggerFactory.getLogger(CartController.class);

    @Autowired
    private CartService cartService;

    /**
     * This method will add given item to cart. User should be authenticated and authorized in order to perform this operation.
     * @param authenticationToken User authentication taken unique for every logged-in user
     * @param cartDto Product to be added to cart
     * @return ResponseEntity {@link String} message to be displayed to the user as response
     * @throws CartException if cart does not exist
     * @throws CurrentUserServiceException if user is not authorized or authenticated
     * @throws UserException if user details are not valid or user unavailable
     * @throws ProductException if product is not available
     */
    @PostMapping("/addproducttocart")
    public ResponseEntity<String> addProductToCart(@RequestParam String authenticationToken,
                                                @RequestBody AddItemToCartDto cartDto)
            throws CartException, CurrentUserServiceException, UserException, ProductException {

        cartService.addItemToCart(cartDto, authenticationToken);    // calling cartService

        logger.info("Item added to cart");

        return new ResponseEntity<>("Item added to cart", HttpStatus.ACCEPTED);

    }

    /**
     * This will update cart details for user. User should be authenticated and authorized in order to perform this operation.
     * @param authenticationToken User authentication taken unique for every logged-in user
     * @param cartDto Product to be updated to cart
     * @return ResponseEntity {@link String} message to be displayed to the user as response
     * @throws CartException if cart does not exist
     * @throws CurrentUserServiceException if user is not authorized or authenticated
     * @throws UserException if user details are not valid or user unavailable
     * @throws ProductException if product is not available
     */
    @PutMapping("/cart")
    public ResponseEntity<String> updateCartItem(@RequestParam String authenticationToken,
                                                 @RequestBody CartItemDto cartDto)
            throws CartException, CurrentUserServiceException, UserException, ProductException {

        cartService.updateCartItem(cartDto, authenticationToken);

        logger.info("Cart Updated");


        return new ResponseEntity<>("Item updated to cart", HttpStatus.ACCEPTED);
    }

    /**
     * Fetch user cart by user id. Here Admin will not able to see items added to users cart.
     * @param authenticationToken User authentication taken unique for every logged-in user
     * @return ResponseEntity {@link CartDto} to be displayed to the user as response
     * @throws CartException if cart does not exist
     * @throws CurrentUserServiceException if user is not authorized or authenticated
     * @throws UserException if user details are not valid or user unavailable
     */
    @GetMapping("/carts/user")
    public ResponseEntity<CartDto> getCartByUserId(@RequestParam String authenticationToken)
            throws CartException, UserException, CurrentUserServiceException {

        CartDto userCart = cartService.getCartByUser(authenticationToken);

        return new ResponseEntity<>(userCart, HttpStatus.OK);

    }

    /**
     * Remove product from user cart.
     * @param authenticationToken User authentication taken unique for every logged-in user
     * @param cartDto Product to be deleted from cart
     * @return ResponseEntity {@link String} message to be displayed to the user as response
     * @throws CartException if cart does not exist
     * @throws CurrentUserServiceException if user is not authorized or authenticated
     * @throws UserException if user details are not valid or user unavailable
     * @throws ProductException if product is not available
     */
    @DeleteMapping("/cart")
    public ResponseEntity<String> removeItemFromCart(@RequestParam String authenticationToken,
                                                     @RequestBody CartItemDto cartDto)
            throws CartException, CurrentUserServiceException, UserException, ProductException {

        cartService.removeCartItem(cartDto, authenticationToken);

        logger.info("Item removed from cart");

        return new ResponseEntity<>("Item removed from cart", HttpStatus.OK);

    }

}
