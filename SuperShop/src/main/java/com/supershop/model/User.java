package com.supershop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @Column(name = "first_name", nullable = false)
    @NotBlank
    @Size(min = 2, message = "first name should have at least two characters")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @NotBlank
    @Size(min = 2, message = "last name should have at least two characters")
    private String lastName;

    @NotBlank
    @Email
    private String email;

    @Embedded
    private Address address;
    private String role;

    @NotEmpty
    @Size(min = 8, message = "password should have at least 8 characters")
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Order> orders;

}
