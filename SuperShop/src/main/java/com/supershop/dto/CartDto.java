package com.supershop.dto;

import com.supershop.model.CartItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {

	private Integer userId;
//	private CartItem cartItem;
	private Integer productId;
	private Integer qantity;
}
