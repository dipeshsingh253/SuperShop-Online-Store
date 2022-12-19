package com.supershop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotBlank
    private String name;

    @NotBlank
    @Size(min = 25, message = "description should contain minimum 25 characters")
    private String description;

    @NotBlank(message = "image link is mandatory")
    private String imageUrl;


    @NotNull
    private Double price;


    @NotNull
    private Integer stock;


    @NotNull
    @OneToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

}
