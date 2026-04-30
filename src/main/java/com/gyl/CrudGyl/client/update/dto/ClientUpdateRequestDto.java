package com.gyl.CrudGyl.client.update.dto;

import com.gyl.CrudGyl.persistence.EntityState;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClientUpdateRequestDto (
        @NotBlank
        String name,

        @NotBlank
        String surname,

        @NotBlank
        String mail,

        @NotBlank
        String phoneNumber,

        @NotBlank
        String address,

        @NotNull
        EntityState state
) {}
