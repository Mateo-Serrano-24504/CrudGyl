package com.gyl.CrudGyl.product.create.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record ProductCreateDto (
        @NotBlank
        String name,

        @NotNull
        @PositiveOrZero
        Double price,

        @NotNull
        @PositiveOrZero
        Long stock,

        @NotNull
        @PositiveOrZero
        Long poductTypeId
) {}
