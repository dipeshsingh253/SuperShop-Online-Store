package com.supershop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * AddItemToCartDto to get request for add item to cart operation.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddItemToCartDto {

	private Integer productId;
	private Integer quantity;
	private Double total;
}
