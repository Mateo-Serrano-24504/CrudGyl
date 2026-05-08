package com.gyl.SalesMicroservice.sale.entity;

import com.gyl.SalesMicroservice.persistence.entity.DatedEntity;
import com.gyl.SalesMicroservice.saleDetail.entity.SaleDetail;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "sales")
@Data
@NoArgsConstructor
@SuperBuilder
public class Sale extends DatedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "total", nullable = false)
    private Double total;

    @Column(name = "client_id", nullable = false)
    private Long clientId;

    @OneToMany(mappedBy = "sale")
    @Builder.Default
    private List<SaleDetail> salesDetails = new ArrayList<>();
}
