package com.gyl.CrudGyl.client.create.service.impl;

import com.gyl.CrudGyl.client.create.dto.ClientCreateResponseDto;
import com.gyl.CrudGyl.client.create.dto.ClientCreateRequestDto;
import com.gyl.CrudGyl.client.create.mapper.ClientCreateMapper;
import com.gyl.CrudGyl.client.create.repository.ClientCreateRepository;
import com.gyl.CrudGyl.client.create.service.ClientCreateService;
import org.springframework.stereotype.Service;

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
        return this.mapper.toDto(
                this.repository.save(this.mapper.fromDto(dto))
        );
    }
}
