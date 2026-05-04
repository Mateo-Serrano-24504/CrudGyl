package com.gyl.CrudGyl.client.create.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public record ClientCreateRequestDto (
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
        String address
) {}
