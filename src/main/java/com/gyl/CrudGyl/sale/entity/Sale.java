package com.gyl.CrudGyl.sale.entity;

import com.gyl.CrudGyl.client.entity.Client;
import com.gyl.CrudGyl.saleDetail.entity.SaleDetail;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sales")
@Getter
@Setter
@NoArgsConstructor
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "date")
    @CreationTimestamp
    Instant createdAt;

    @Column(name = "total")
    Double total;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany
    private List<SaleDetail> salesDetails = new ArrayList<>();

    public Sale(Double total) {
        this.total = total;
    }
}
