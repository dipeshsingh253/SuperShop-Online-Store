package com.supershop.dto;

import com.supershop.model.Payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailsDto {

	private Integer orderId;
	private PaymentDto paymentDetails;
	private String orderStatus;

}
