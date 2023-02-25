package com.supershop.model;

import javax.persistence.Embeddable;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity Model for payment table.
 */



@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payment")
public class Payment {

	// private Integer id;

	@NotBlank
	private String paymentStatus;

	@NotBlank
	private String paymentMethod;

	@NotNull
	private Double amount;

}
