package com.supershop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	
	@Embedded
	private Address address;
	private String role;
	private String password;
	
	@OneToOne
	@JoinColumn(name = "cart_id",referencedColumnName = "id")
//	@NotFound(action = NotFoundAction.IGNORE)
	private Cart cart;
	
	@OneToMany
	@NotFound(action = NotFoundAction.IGNORE)
	private List<Order> orders = new ArrayList<>();

}
