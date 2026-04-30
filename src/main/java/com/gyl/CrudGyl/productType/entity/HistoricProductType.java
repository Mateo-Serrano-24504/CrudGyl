package com.gyl.CrudGyl.productType.entity;

import com.gyl.CrudGyl.persistence.EntityState;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "historic_product_types")
@Getter
@Setter
@NoArgsConstructor
public class HistoricProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "product_type_id")
    private Long productTypeId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "valid_from")
    private Instant validFrom;

    @Column(name = "valid_to")
    private Instant validTo;

    @Column(name = "state")
    private EntityState state;

    public HistoricProductType(ProductType productType) {
        this.productTypeId = productType.getId();
        this.name = productType.getName();
        this.description = productType.getDescription();
        this.validFrom = productType.getValidSince();
        this.state = productType.getState();
    }
}
