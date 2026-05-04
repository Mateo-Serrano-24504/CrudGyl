package com.gyl.CrudGyl.saleDetail.entity;

import com.gyl.CrudGyl.persistence.EntityState;
import com.gyl.CrudGyl.product.entity.Product;
import com.gyl.CrudGyl.sale.entity.Sale;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "sales_details")
@Getter
@Setter
@NoArgsConstructor
public class SaleDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "unit_price")
    private Double unitPrice;

    @Column(name = "subtotal")
    private Double subtotal;

    @Column(name = "valid_since")
    private Instant validSince;

    @Column(name = "state")
    private EntityState state;

    @Column(name = "created_at")
    private Instant createdAt;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public SaleDetail(Long amount, EntityState state) {
        this.amount = amount;
        this.state = state;
    }
}
