package com.gyl.CrudGyl.productType.update.dto;

import com.gyl.CrudGyl.persistence.EntityState;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductTypeUpdateRequestDto (
        @NotBlank
        String name,

        @NotBlank
        String description,

        @NotNull
        EntityState state
) {}
