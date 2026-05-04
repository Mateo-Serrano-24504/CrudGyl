package com.gyl.CrudGyl.sale.entity;

import com.gyl.CrudGyl.client.entity.Client;
import com.gyl.CrudGyl.persistence.EntityState;
import com.gyl.CrudGyl.saleDetail.entity.SaleDetail;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(name = "total", nullable = false)
    Double total;

    @Column(name = "valid_since", nullable = false)
    private Instant validSince;

    @Column(name = "state", nullable = false)
    private EntityState state;

    @Column(name = "date", nullable = false)
    Instant createdAt;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private List<SaleDetail> salesDetails = new ArrayList<>();
}
