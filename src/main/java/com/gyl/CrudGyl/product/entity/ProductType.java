package com.gyl.CrudGyl.product.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private final String name;

    @Column(name = "description")
    private final String description;

    public ProductType(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
