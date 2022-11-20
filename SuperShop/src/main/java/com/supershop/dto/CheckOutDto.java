package com.supershop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/*
 * when user will click to check out all the items in cart we will get the data in form of this dto class object
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckOutDto {

	private Integer userId;
	private String paymentMethod;

}
