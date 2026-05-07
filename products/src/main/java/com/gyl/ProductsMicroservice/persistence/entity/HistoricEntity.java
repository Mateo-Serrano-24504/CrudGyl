package com.gyl.ProductsMicroservice.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Instant;

@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@Data
public class HistoricEntity<T extends HistoricEntity<T>> extends DatedEntity<T> {
    @Column(name = "valid_to", nullable = false)
    protected Instant validTo;
}
