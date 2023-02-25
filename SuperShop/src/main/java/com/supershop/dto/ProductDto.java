package com.supershop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * ProductDto to share product details available in Product table with users as response. Also can be used as request to update product details.
 */

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
