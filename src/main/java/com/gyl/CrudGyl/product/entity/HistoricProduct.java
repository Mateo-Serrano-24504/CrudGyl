package com.gyl.CrudGyl.product.entity;

import com.gyl.CrudGyl.persistence.EntityState;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "historic_products")
@Getter
@Setter
@NoArgsConstructor
public class HistoricProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "stock", nullable = false)
    private Long stock;

    @Column(name = "product_type_id", nullable = false)
    private Long productTypeId;

    @Column(name = "valid_from", nullable = false)
    private Instant validFrom;

    @Column(name = "valid_to", nullable = false)
    private Instant validTo;

    @Column(name = "state", nullable = false)
    private EntityState state;

    public HistoricProduct(Product product) {
        this.productId = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.stock = product.getStock();
        this.state = product.getState();
        this.validFrom = product.getValidSince();
        this.productTypeId = product.getProductType().getId();
    }
}
