package com.gyl.CrudGyl.client.create.builder.impl;

import com.gyl.CrudGyl.client.create.builder.ClientCreateClientBuilder;
import com.gyl.CrudGyl.client.create.dto.ClientCreateRequestDto;
import com.gyl.CrudGyl.client.create.mapper.ClientCreateMapper;
import com.gyl.CrudGyl.client.entity.Client;
import com.gyl.CrudGyl.persistence.EntityState;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class ClientCreateClientBuilderImpl implements ClientCreateClientBuilder {
    private final ClientCreateMapper mapper;
    public ClientCreateClientBuilderImpl(ClientCreateMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Client build(ClientCreateRequestDto dto, Instant time) {
        Client client = this.mapper.fromDto(dto);
        client.setValidSince(time);
        client.setCreatedAt(time);
        client.setState(EntityState.ACTIVE);
        return client;
    }
}
