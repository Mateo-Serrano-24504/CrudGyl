package com.gyl.CrudGyl.saleDetail.entity;

import com.gyl.CrudGyl.client.entity.Client;
import com.gyl.CrudGyl.sale.entity.Sale;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @JoinColumn(name = "sale_id")
    @ManyToOne
    private Sale sale;

    public SaleDetail(Long amount, Double unitPrice, Double subtotal) {
        this.amount = amount;
        this.unitPrice = unitPrice;
        this.subtotal = subtotal;
    }
}
