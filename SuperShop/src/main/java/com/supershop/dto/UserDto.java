package com.supershop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 
 * we will accept admin details for a new admin from this table we can also use this form for registering customers also but not recommended
 * 
 */



@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String role;

}
