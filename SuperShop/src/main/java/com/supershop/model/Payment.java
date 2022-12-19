package com.supershop.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

	// private Integer id;

	@NotBlank
	private String paymentStatus;

	@NotBlank
	private String paymentMethod;

	@NotNull
	private Double amount;

}
