package com.supershop.model;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

	private String building;
	private String society;
	private String area;
	private String city;
	private String pincode;
	private String state;
	private String country;

}
