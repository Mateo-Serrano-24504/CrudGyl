package com.gyl.CrudGyl.client.read.service.impl;

import com.gyl.CrudGyl.client.entity.Client;
import com.gyl.CrudGyl.client.read.dto.ClientReadResponseDto;
import com.gyl.CrudGyl.client.read.exception.ClientReadClientDoesNotExist;
import com.gyl.CrudGyl.client.read.mapper.ClientReadMapper;
import com.gyl.CrudGyl.client.read.repository.ClientReadRepository;
import com.gyl.CrudGyl.client.read.service.ClientReadService;
import org.springframework.stereotype.Service;

@Service
public class ClientReadServiceImpl implements ClientReadService {
    private final ClientReadRepository repository;
    private final ClientReadMapper mapper;
    public ClientReadServiceImpl(
            ClientReadRepository repository,
            ClientReadMapper mapper
    ) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public ClientReadResponseDto read(Long id) {
        Client client = this.repository
                .findById(id)
                .orElseThrow(() -> new ClientReadClientDoesNotExist(id));
        return this.mapper.toDto(client);
    }
}
