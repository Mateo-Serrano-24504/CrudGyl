package com.gyl.CrudGyl.client.read.mapper;

import com.gyl.CrudGyl.client.entity.Client;
import com.gyl.CrudGyl.client.read.dto.ClientReadResponseDto;
import org.springframework.stereotype.Component;

import java.time.ZoneOffset;

@Component
public class ClientReadMapper {
    public ClientReadResponseDto toDto(Client client) {
        return new ClientReadResponseDto(
                client.getId(),
                client.getName(),
                client.getSurname(),
                client.getMail(),
                client.getPhoneNumber(),
                client.getAddress(),
                client.getValidSince().atOffset(ZoneOffset.UTC),
                client.getState(),
                client.getCreatedAt().atOffset(ZoneOffset.UTC)
        );
    }
}
