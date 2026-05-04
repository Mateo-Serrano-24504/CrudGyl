package com.gyl.CrudGyl.client.update.service.impl;

import com.gyl.CrudGyl.client.entity.Client;
import com.gyl.CrudGyl.client.entity.HistoricClient;
import com.gyl.CrudGyl.client.update.builder.ClientUpdateClientBuilder;
import com.gyl.CrudGyl.client.update.dto.ClientUpdateRequestDto;
import com.gyl.CrudGyl.client.update.dto.ClientUpdateResponseDto;
import com.gyl.CrudGyl.client.update.exception.ClientUpdateClientDoesNotExist;
import com.gyl.CrudGyl.client.update.mapper.ClientUpdateMapper;
import com.gyl.CrudGyl.client.update.repository.ClientUpdateRepository;
import com.gyl.CrudGyl.client.update.repository.HistoricClientCreateRepository;
import com.gyl.CrudGyl.client.update.service.ClientUpdateService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Transactional
public class ClientUpdateServiceImpl implements ClientUpdateService {
    private final ClientUpdateRepository repository;
    private final HistoricClientCreateRepository historicClientCreateRepository;
    private final ClientUpdateMapper mapper;
    private final ClientUpdateClientBuilder builder;
    public ClientUpdateServiceImpl(
            ClientUpdateRepository repository,
            HistoricClientCreateRepository historicClientCreateRepository,
            ClientUpdateMapper mapper,
            ClientUpdateClientBuilder builder
    ) {
        this.repository = repository;
        this.historicClientCreateRepository = historicClientCreateRepository;
        this.mapper = mapper;
        this.builder = builder;
    }

    private HistoricClient createHistoricClient(Client oldClient, Instant invalidationTime) {
        HistoricClient historicClient = new HistoricClient(oldClient);
        historicClient.setValidTo(invalidationTime);
        return historicClient;
    }

    @Override
    public ClientUpdateResponseDto update(Long id, ClientUpdateRequestDto dto) {
        Instant now = Instant.now();
        Client client = this.repository
                .findById(id)
                .orElseThrow(() -> new ClientUpdateClientDoesNotExist(id));
        this.historicClientCreateRepository.save(this.createHistoricClient(client, now));
        Client newClient = this.builder.build(client, dto, now);
        return this.mapper.toDto(
                this.repository.save(newClient)
        );
    }
}
