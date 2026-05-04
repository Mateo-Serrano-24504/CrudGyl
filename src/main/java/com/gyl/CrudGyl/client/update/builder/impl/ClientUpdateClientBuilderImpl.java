package com.gyl.CrudGyl.client.update.builder.impl;

import com.gyl.CrudGyl.client.entity.Client;
import com.gyl.CrudGyl.client.update.builder.ClientUpdateClientBuilder;
import com.gyl.CrudGyl.client.update.dto.ClientUpdateRequestDto;
import com.gyl.CrudGyl.client.update.mapper.ClientUpdateMapper;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class ClientUpdateClientBuilderImpl implements ClientUpdateClientBuilder {
    private final ClientUpdateMapper mapper;
    public ClientUpdateClientBuilderImpl(ClientUpdateMapper mapper) {
        this.mapper = mapper;
    }


    @Override
    public Client build(Client original, ClientUpdateRequestDto dto, Instant time) {
        Client newClient = this.mapper.fromDto(dto);
        newClient.setId(original.getId());
        newClient.setValidSince(time);
        newClient.setCreatedAt(original.getCreatedAt());
        return newClient;
    }
}
