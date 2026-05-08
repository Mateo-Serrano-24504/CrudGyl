package com.gyl.SalesMicroservice.persistence.entity;

import com.gyl.SalesMicroservice.persistence.EntityState;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.util.function.Supplier;

@Data
@MappedSuperclass
public class StatefulEntity<T extends StatefulEntity<T>> {
    @Enumerated(EnumType.STRING)
    @Column(name = "state", nullable = false)
    protected EntityState state;

    @SuppressWarnings("unchecked")
    public T assertActive(Supplier<? extends RuntimeException> exceptionSupplier) {
        if (this.state == EntityState.INACTIVE) {
            throw exceptionSupplier.get();
        }
        return (T) this;
    }
}
