package com.gyl.CrudGyl.sale.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

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

    public Sale(Double total) {
        this.total = total;
    }
}
