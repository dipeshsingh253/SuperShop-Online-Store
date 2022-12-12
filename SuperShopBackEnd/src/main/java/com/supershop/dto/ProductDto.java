package com.supershop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

	private Integer id;

	private String name;
	private String imageUrl;

	private String description;
	private Double price;

	private Integer categoryId;

}
