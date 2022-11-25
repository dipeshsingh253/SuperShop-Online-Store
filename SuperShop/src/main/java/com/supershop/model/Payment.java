package com.supershop.model;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

	// private Integer id;
	private String paymentStatus;
	private String paymentMethod;
	private Double amount;

}
