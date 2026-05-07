package com.gyl.ClientsMicroservice.client.create.service.impl;

import com.gyl.ClientsMicroservice.client.create.builder.ClientCreateClientBuilder;
import com.gyl.ClientsMicroservice.client.create.dto.ClientCreateResponseDto;
import com.gyl.ClientsMicroservice.client.create.dto.ClientCreateRequestDto;
import com.gyl.ClientsMicroservice.client.create.mapper.ClientCreateMapper;
import com.gyl.ClientsMicroservice.client.create.repository.ClientCreateRepository;
import com.gyl.ClientsMicroservice.client.create.service.ClientCreateService;
import com.gyl.ClientsMicroservice.client.entity.Client;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Transactional
@RequiredArgsConstructor
public class ClientCreateServiceImpl implements ClientCreateService {
    private final ClientCreateRepository repository;
    private final ClientCreateMapper mapper;
    private final ClientCreateClientBuilder builder;

    @Override
    public ClientCreateResponseDto create(ClientCreateRequestDto dto) {
        Client client = this.builder.build(dto, Instant.now());
        return this.mapper.toDto(
                this.repository.save(client)
        );
    }
}
