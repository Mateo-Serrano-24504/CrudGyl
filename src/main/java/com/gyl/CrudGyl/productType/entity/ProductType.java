package com.gyl.CrudGyl.productType.entity;

import com.gyl.CrudGyl.persistence.entity.DatedEntity;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "product_types")
@Data
@NoArgsConstructor
public class ProductType extends DatedEntity<ProductType> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "description")
    private String description;
}
