package com.gyl.CrudGyl.client.update.mapper;

import com.gyl.CrudGyl.client.entity.Client;
import com.gyl.CrudGyl.client.update.dto.ClientUpdateRequestDto;
import com.gyl.CrudGyl.client.update.dto.ClientUpdateResponseDto;
import org.mapstruct.Mapper;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Mapper(componentModel = "spring")
public interface ClientUpdateMapper {
    Client fromDto(ClientUpdateRequestDto dto);
    ClientUpdateResponseDto toDto(Client client);

    @SuppressWarnings("unused")
    default OffsetDateTime map(Instant value) {
        return value == null ? null : value.atOffset(ZoneOffset.UTC);
    }
}
