package com.supershop.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity Model for current_user_session table.
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "current_user_session")
public class CurrentUserSession {

	@Id
	private Integer userId;
	private LocalDateTime sessionStartedDateTime;

	@NotBlank
	private String authenticationToken;

	@NotBlank
	private String role;

	@NotBlank
	private String email;

}
