package com.gyl.CrudGyl.client.create.service.impl;

import com.gyl.CrudGyl.client.create.dto.ClientCreateResponseDto;
import com.gyl.CrudGyl.client.create.dto.ClientCreateRequestDto;
import com.gyl.CrudGyl.client.create.mapper.ClientCreateMapper;
import com.gyl.CrudGyl.client.create.repository.ClientCreateRepository;
import com.gyl.CrudGyl.client.create.service.ClientCreateService;
import com.gyl.CrudGyl.client.entity.Client;
import com.gyl.CrudGyl.persistence.EntityState;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class ClientCreateServiceImpl implements ClientCreateService {
    private final ClientCreateRepository repository;
    private final ClientCreateMapper mapper;
    public ClientCreateServiceImpl(ClientCreateRepository repository, ClientCreateMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ClientCreateResponseDto create(ClientCreateRequestDto dto) {
        Instant now = Instant.now();
        Client client = this.mapper.fromDto(dto);
        client.setValidSince(now);
        client.setCreatedAt(now);
        client.setState(EntityState.ACTIVE);
        return this.mapper.toDto(
                this.repository.save(client)
        );
    }
}
