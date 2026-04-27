package com.gyl.CrudGyl.productType.create.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record ProductTypeCreateDto (
        @NotBlank
        String name,

        @NotBlank
        @Length(min = 1, max = 126)
        String description
) {}
