package com.supershop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * CartItemDto to send Product details of cart with user as response. Also used as request to update product details in cart.
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDto {
	private Integer id;
	private Integer userId;
	private ProductDto productDto;
	private Integer quantity;
	private Double total;
}
