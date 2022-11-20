package com.supershop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/*
 * 
 * we will send product details to front-end in form of this dto class object
 * 
 */


@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductDto {

	private String name;
	private String description;

	private String imageUrl;

	private Double price;

	private Integer stock;

	private String category;

}
