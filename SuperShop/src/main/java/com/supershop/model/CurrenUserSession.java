package com.supershop.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrenUserSession {

	@Id
	private Integer userId;
	private LocalDateTime sessionStarteDateTime;
	private String authenticationToken;
	private String role;
	private String email;

}
