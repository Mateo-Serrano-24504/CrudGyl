package com.gyl.ClientsMicroservice.client.update.dto;

import com.gyl.ClientsMicroservice.persistence.EntityState;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public record ClientUpdateRequestDto (
        @NotBlank
        @Length(min = 1, max = 126)
        String name,

        String surname,

        @Email
        @Length(min = 1, max = 126)
        String mail,

        @Pattern(regexp = "^\\d{8}$")
        String phoneNumber,

        @NotBlank
        @Length(min = 1, max = 126)
        String address,

        @NotNull
        EntityState state
) {}
