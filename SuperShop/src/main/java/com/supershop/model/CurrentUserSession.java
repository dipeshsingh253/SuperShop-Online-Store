package com.supershop.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrentUserSession {

	@Id
	private Integer userId;
	private LocalDateTime sessionStarteDateTime;

	@NotBlank
	private String authenticationToken;

	@NotBlank
	private String role;

	@NotBlank
	private String email;

}
