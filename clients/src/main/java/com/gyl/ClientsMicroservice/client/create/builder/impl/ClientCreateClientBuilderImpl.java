package com.gyl.ClientsMicroservice.client.create.builder.impl;

import com.gyl.ClientsMicroservice.client.create.builder.ClientCreateClientBuilder;
import com.gyl.ClientsMicroservice.client.create.dto.ClientCreateRequestDto;
import com.gyl.ClientsMicroservice.client.create.mapper.ClientCreateMapper;
import com.gyl.ClientsMicroservice.client.entity.Client;
import com.gyl.ClientsMicroservice.persistence.EntityState;
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
