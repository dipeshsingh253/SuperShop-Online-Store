package com.supershop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterAdminDto {

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String role;

}
