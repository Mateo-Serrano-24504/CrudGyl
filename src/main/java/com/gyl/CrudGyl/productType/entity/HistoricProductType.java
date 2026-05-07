package com.gyl.CrudGyl.productType.entity;

import com.gyl.CrudGyl.persistence.entity.HistoricEntity;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "historic_product_types")
@Data
@NoArgsConstructor
public class HistoricProductType extends HistoricEntity<HistoricProductType> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "product_type_id", nullable = false)
    private Long productTypeId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;
}
