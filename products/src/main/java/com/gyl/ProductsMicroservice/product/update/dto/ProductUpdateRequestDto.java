package com.gyl.ProductsMicroservice.product.update.dto;

import com.gyl.ProductsMicroservice.persistence.EntityState;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductUpdateRequestDto (
        @NotBlank
        String name,

        @Positive
        Double price,

        @Positive
        Long stock,

        @Positive
        Long productTypeId,

        @NotNull
        EntityState state
) {}
