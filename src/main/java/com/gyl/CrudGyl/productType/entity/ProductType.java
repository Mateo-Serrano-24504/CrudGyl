package com.gyl.CrudGyl.productType.entity;

import com.gyl.CrudGyl.product.entity.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product_types")
@Getter
@NoArgsConstructor
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "productType")
    private List<Product> products = new ArrayList<>();

    public ProductType(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
