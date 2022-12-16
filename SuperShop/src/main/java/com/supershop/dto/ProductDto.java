package com.supershop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

	private Integer id;
	private String name;
	private String description;
	private String imageUrl;
	private Double price;
	private Integer stock;

}
