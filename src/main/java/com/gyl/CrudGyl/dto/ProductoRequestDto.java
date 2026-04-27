package com.gyl.CrudGyl.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductoRequestDto (
        @NotBlank(message = "El nombre no puede ser vacío")
        String nombre,

        @NotNull(message = "El precio es obligatorio")
        @Positive(message = "El precio no puede ser negativo")
        Double precio,

        @NotNull(message = "El stock es obligatorio")
        @Min(value = 0, message = "El stock no puede ser negativo")
        Integer stock
) {}
