package com.gyl.CrudGyl.product.entity;

import com.gyl.CrudGyl.persistence.entity.HistoricEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "historic_products")
@Getter
@Setter
@NoArgsConstructor
public class HistoricProduct extends HistoricEntity<HistoricProduct> {
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
}
