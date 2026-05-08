package com.gyl.SalesMicroservice.persistence.entity;

import com.gyl.SalesMicroservice.persistence.EntityState;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.function.Supplier;

@Data
@MappedSuperclass
@NoArgsConstructor
@SuperBuilder
public class StatefulEntity {
    @Enumerated(EnumType.STRING)
    @Column(name = "state", nullable = false)
    protected EntityState state;
}
