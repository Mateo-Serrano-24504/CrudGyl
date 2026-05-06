package com.gyl.CrudGyl.product.entity;

import com.gyl.CrudGyl.persistence.EntityState;
import com.gyl.CrudGyl.persistence.entity.DatedEntity;
import com.gyl.CrudGyl.productType.entity.ProductType;
import com.gyl.CrudGyl.saleDetail.entity.SaleDetail;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
public class Product extends DatedEntity<Product> {
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
