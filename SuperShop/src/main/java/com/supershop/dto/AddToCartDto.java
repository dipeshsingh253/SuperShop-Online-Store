package com.supershop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddToCartDto {
	
//	private Integer userId;
//	private CartItem cartItem;
	private Integer productId;
	private Integer qantity;

	private Double total;

}	
