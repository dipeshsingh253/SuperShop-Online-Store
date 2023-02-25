package com.supershop.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * CartDto to send cart details of user as response.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {

	private Integer userId;

	private List<CartItemDto> cartItems;

	private Double totalCost;

	private String paymentMethod;

}
