package com.gyl.CrudGyl.client.update.dto;

import com.gyl.CrudGyl.persistence.EntityState;

import java.time.OffsetDateTime;

public record ClientUpdateResponseDto (
        Long id,
        String name,
        String surname,
        String mail,
        String phoneNumber,
        String address,
        OffsetDateTime validSince,
        EntityState state,
        OffsetDateTime createdAt
) {}
