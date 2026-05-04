package com.gyl.CrudGyl.product.entity;

import com.gyl.CrudGyl.persistence.EntityState;
import com.gyl.CrudGyl.productType.entity.ProductType;
import com.gyl.CrudGyl.saleDetail.entity.SaleDetail;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "stock", nullable = false)
    private Long stock;

    @ManyToOne
    @JoinColumn(name = "product_type_id", nullable = false)
    private ProductType productType;

    @Column(name = "valid_since", nullable = false)
    private Instant validSince;

    @Column(name = "state", nullable = false)
    private EntityState state;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @OneToMany(mappedBy = "product")
    private List<SaleDetail> salesDetails = new ArrayList<>();

    public Product(String name, Double price, Long stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    public Product(String name, Double price, Long stock, EntityState state) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.state = state;
    }
}
