package com.supershop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * when user will click add any product to add to cart we will get request in form of this dto class and then we will save it in service implementation
 * 
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {

	private Integer userId;
	private String productName;

}
