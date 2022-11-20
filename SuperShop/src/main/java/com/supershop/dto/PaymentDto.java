package com.supershop.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentDto {

	private Integer id;
	private String type;
	private Double amount;
	private List<ProductDto> products;
	private String status;
}
