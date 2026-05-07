package com.gyl.CrudGyl.client.read.mapper;

import com.gyl.CrudGyl.client.entity.Client;
import com.gyl.CrudGyl.client.read.dto.ClientReadResponseDto;
import org.mapstruct.Mapper;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Mapper(componentModel = "spring")
public interface ClientReadMapper {
    ClientReadResponseDto toDto(Client client);

    default OffsetDateTime map(Instant value) {
        return value == null ? null : value.atOffset(ZoneOffset.UTC);
    }
}
