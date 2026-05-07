package com.gyl.ProductsMicroservice.productType.update.dto;

import com.gyl.ProductsMicroservice.persistence.EntityState;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record ProductTypeUpdateRequestDto (
        @NotBlank
        @Length(min = 1, max = 126)
        String name,

        String description,

        @NotNull
        EntityState state
) {}
