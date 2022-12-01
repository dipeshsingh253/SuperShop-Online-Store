package com.supershop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
//for creating order id is not required but for updating orders id is mandatory
	private Integer orderId;
	private Integer userId;
	private String paymentMethod;
	private String orderStatus;

}
