package com.gyl.CrudGyl.client.read.service.impl;

import com.gyl.CrudGyl.client.entity.Client;
import com.gyl.CrudGyl.client.read.dto.ClientReadResponseDto;
import com.gyl.CrudGyl.client.read.exception.ClientReadClientDoesNotExist;
import com.gyl.CrudGyl.client.read.mapper.ClientReadMapper;
import com.gyl.CrudGyl.client.read.repository.ClientReadRepository;
import com.gyl.CrudGyl.client.read.service.ClientReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ClientReadServiceImpl implements ClientReadService {
    private final ClientReadRepository repository;
    private final ClientReadMapper mapper;


    @Override
    public ClientReadResponseDto read(Long id) {
        Client client = this.repository
                .findById(id)
                .orElseThrow(() -> new ClientReadClientDoesNotExist(id));
        return this.mapper.toDto(client);
    }
}
