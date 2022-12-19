package com.supershop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddItemToCartDto {



	private Integer productId;
//	private CartItem cartItem;
//	private ProductDto productDto;
	private Integer qantity;

	private Double total;
}
