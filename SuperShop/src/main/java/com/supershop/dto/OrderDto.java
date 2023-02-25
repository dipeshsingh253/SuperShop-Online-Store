package com.supershop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * OrderDto to create new order or update existing order. In order to update existing order the order id is mandatory.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
	private Integer orderId;
	private Integer userId;
	private String paymentMethod;
	private String orderStatus;
}
