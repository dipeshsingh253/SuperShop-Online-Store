package com.supershop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 
 * we will return order details in form of this dto class object
 * 
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailsDto {

	private Integer orderId;
	private PaymentDto paymentDetails;
	private String orderStatus;

}
