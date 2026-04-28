package com.gyl.CrudGyl.product.entity;

import com.gyl.CrudGyl.productType.entity.ProductType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "stock")
    private Long stock;

    @ManyToOne
    @JoinColumn(name = "product_type_id")
    private ProductType productType;

    public Product(String name, Double price, Long stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}
