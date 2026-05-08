package com.gyl.SalesMicroservice.saleDetail.entity;

import com.gyl.SalesMicroservice.persistence.entity.DatedEntity;
import com.gyl.SalesMicroservice.sale.entity.Sale;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "sales_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class SaleDetail extends DatedEntity<SaleDetail> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "amount", nullable = false)
    private Long amount;

    @Column(name = "unit_price", nullable = false)
    private Double unitPrice;

    @Column(name = "subtotal", nullable = false)
    private Double subtotal;

    @ManyToOne
    @JoinColumn(name = "sale_id", nullable = false)
    private Sale sale;

    @Column(name = "product_id", nullable = false)
    private Long productId;
}
