package com.gyl.CrudGyl.productType.entity;

import com.gyl.CrudGyl.persistence.EntityState;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "product_types")
@Getter
@Setter
@NoArgsConstructor
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "valid_since", nullable = false)
    private Instant validSince;

    @Column(name = "state", nullable = false)
    private EntityState state;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    public ProductType(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public ProductType(String name, String description, EntityState state) {
        this.name = name;
        this.description = description;
        this.state = state;
    }
}
