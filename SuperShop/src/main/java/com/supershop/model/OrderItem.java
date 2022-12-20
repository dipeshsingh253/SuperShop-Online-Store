package com.supershop.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ordereditems")
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer quantity;

	private Double totalPrice;

	private LocalDateTime createDateTime;



	// many order items can belong to a same order
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "order_id", referencedColumnName = "id")
	private Order order;


	// every order item will have reference to the ordered product
	@OneToOne
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private Product product;

}
