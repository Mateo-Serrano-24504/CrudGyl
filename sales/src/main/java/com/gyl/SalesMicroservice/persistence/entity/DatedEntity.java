package com.gyl.SalesMicroservice.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@EqualsAndHashCode(callSuper = true)
@Data
@MappedSuperclass
@NoArgsConstructor
@SuperBuilder
public class DatedEntity extends StatefulEntity {
    @Column(name = "created_at", nullable = false)
    protected Instant createdAt;

    @Column(name = "valid_since", nullable = false)
    protected Instant validSince;
}
