package com.gyl.CrudGyl.sale.update.dto;

import com.gyl.CrudGyl.persistence.EntityState;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record SaleUpdateRequestDto (
        @NotNull
        EntityState state,

        @Positive
        Long clientId
) {}
