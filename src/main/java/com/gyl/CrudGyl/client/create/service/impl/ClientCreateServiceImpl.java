package com.gyl.CrudGyl.client.create.service.impl;

import com.gyl.CrudGyl.client.create.builder.ClientCreateClientBuilder;
import com.gyl.CrudGyl.client.create.dto.ClientCreateResponseDto;
import com.gyl.CrudGyl.client.create.dto.ClientCreateRequestDto;
import com.gyl.CrudGyl.client.create.mapper.ClientCreateMapper;
import com.gyl.CrudGyl.client.create.repository.ClientCreateRepository;
import com.gyl.CrudGyl.client.create.service.ClientCreateService;
import com.gyl.CrudGyl.client.entity.Client;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class ClientCreateServiceImpl implements ClientCreateService {
    private final ClientCreateRepository repository;
    private final ClientCreateMapper mapper;
    private final ClientCreateClientBuilder builder;
    public ClientCreateServiceImpl(
            ClientCreateRepository repository,
            ClientCreateMapper mapper,
            ClientCreateClientBuilder builder
    ) {
        this.repository = repository;
        this.mapper = mapper;
        this.builder = builder;
    }

    @Override
    public ClientCreateResponseDto create(ClientCreateRequestDto dto) {
        Client client = this.builder.build(dto, Instant.now());
        return this.mapper.toDto(
                this.repository.save(client)
        );
    }
}
