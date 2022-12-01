package com.supershop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDto {

	private Integer userId;
//	private CartItem cartItem;
	private ProductDto productDto;
	private Integer qantity;

	private Double total;
}
